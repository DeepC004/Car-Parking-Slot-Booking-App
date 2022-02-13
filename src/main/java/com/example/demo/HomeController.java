package com.example.demo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.hibernate.annotations.Check;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

//@RestController
@Controller
public class HomeController {
    int costPerHour;
    int totalCost;
    int hours;
    @Autowired
    private UserRepository repo;

    @Bean
    public PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private ActiveRegistrationsRepository repo2;
    @Autowired
    private ParkingRepository repo1;


    @Autowired
    private WorkerRepository repo3;
    @GetMapping("/login")
    public String login(){
    return "login";
}
    @PostMapping("/userlogin")
//    public String userlogin(@ModelAttribute String username){
    public String userlogin(){
//        System.out.println("Username from userlogin: " + username);
//        User user = repo.findByUsername(username);
//
//        if (user.getRole().equals("USER")) {
//            return "dashboard";
//        }
//        return "adminDashboard";
            return "dashboard";
    }
    @GetMapping("/dashboard")
    public String home(){
//    public void home(){
//        return "This is HP";
//        System.out.println("This is test 123");
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/registration")
    public String register() {
        return "registration";
    }
    @PostMapping("/userdata")
    public String register(@ModelAttribute User user, Model model){
//    public String register(@RequestBody User user){
        String password = user.getPassword();
        user.setPassword(encoder().encode(password));
        repo.saveAndFlush(user);

        model.addAttribute("message", "User Registration Successful");
        return "redirect:/login";
    }

    @PostMapping("/addedParking")
    public String addedParking(@ModelAttribute Parking parking, Model model) {
        repo1.saveAndFlush(parking);
        model.addAttribute("message", "Parking Addition Successful");
        return "redirect:/admin";
    }

    @PostMapping("/newBooking")
    public String newBooking(@ModelAttribute ActiveRegistrationsDTO activeRegistrationsDTO, Model model) {
        System.out.println("Booking successful!");
        System.out.println(activeRegistrationsDTO.toString());

        ActiveRegistrations activeRegistrations = new ActiveRegistrations();
        BeanUtils.copyProperties(activeRegistrationsDTO, activeRegistrations);

        final DateFormat iso8601DateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        iso8601DateFormatter.setTimeZone(TimeZone.getDefault());

        try {
            activeRegistrations.setActive_date(iso8601DateFormatter.parse(activeRegistrationsDTO.getActive_date()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(activeRegistrations.toString());

        repo2.saveAndFlush(activeRegistrations);
        model.addAttribute("message", "Booking Successful");
        int originalCost = 25;
        String str2 = "yes";

        String carwash = activeRegistrations.getCarWash();
        if((carwash != null) && carwash.equals(str2)){
            originalCost += 4;
        }

        String carvacuum = activeRegistrations.getCarVacuum();
        if((carvacuum != null) && carvacuum.equals(str2)){
            originalCost += 8;
        }

        String airpressurecheck = activeRegistrations.getAirPressureCheck();
        if((airpressurecheck != null) && airpressurecheck.equals(str2)){
            originalCost += 2;
        }

        String windowcleaning = activeRegistrations.getWindowCleaning();
        if((windowcleaning != null) && windowcleaning.equals(str2)){
            originalCost += 3;
        }
        costPerHour = originalCost;
        hours = activeRegistrations.getCheckout() - activeRegistrations.getCheckin();
        if(hours < 0){
            hours = 24 + hours;
        }
        if(hours >= 24){
            return "redirect:/error";
        }
        totalCost = hours * costPerHour;
        System.out.println(costPerHour);
        System.out.println(totalCost);
        CheckoutDTO cost = new CheckoutDTO(costPerHour, totalCost);
        model.addAttribute("cost", cost);
        return "checkout";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @PostMapping("/rating")
    public String rating() {
        return "rating";
    }
    @PostMapping("/request")
    public String request(){
        return "request";
    }
    @PostMapping("/requested")
    public String requested(){
        return "redirect:/dashboard";
    }

//    @PostMapping("/admin")
    @GetMapping("/adminDashboard")
    public String adminDashboard(Model model) {
        List<Worker> workerList = repo3.findAll();
        List<WorkerDTO> workerDTOList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(workerList)) {
            for (Worker worker : workerList) {
                WorkerDTO workerDTO = new WorkerDTO();
                BeanUtils.copyProperties(worker, workerDTO);
                workerDTOList.add(workerDTO);
            }
        }
        model.addAttribute("workerData", workerDTOList);

        List<Parking> parkingList = repo1.findAll();
        List<ParkingDTO> parkingDTOList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(parkingList)) {
            for (Parking parking : parkingList) {
                ParkingDTO parkingDTO = new ParkingDTO();
                BeanUtils.copyProperties(parking, parkingDTO);
                parkingDTOList.add(parkingDTO);
            }
        }
        model.addAttribute("parkingData", parkingDTOList);

        return "adminDashboard";
    }

    @PostMapping("/afterLogout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                System.out.println("Auth successfully received!");
                new SecurityContextLogoutHandler().logout(request, response, auth);
            } else {
                System.out.println("Auth NOT received!");
            }

//            logger.info("User logged out with username =" + logOutRequest.getUserId());
//            return new ResponseEntity<String>("Logged Out Successfully", HttpStatus.OK);
        } catch (Exception e) {
//            logger.error("Invalid User tried logging out with user id =" + logOutRequest.getUserId());
//            return new ResponseEntity<String>("Invalid userid", HttpStatus.BAD_REQUEST);
        }
        return "dashboard";
    }


    @Modifying
    @Transactional
    @DeleteMapping("/removeParking")
    /*
    *       APPLY SAME LOGIC FOR THIS AS THAT FOR removeWorker()
    * */
    public void removeParking(@RequestParam(name = "removeParking", defaultValue = "") String parkingLocation/*WHAT TO INPUT HERE*/){
        if (parkingLocation != "") {
            repo1.deleteByParkingLocation(parkingLocation);
        } else {
            System.out.println("Cannot remove parking! Missing parameter : 'removeParking'.");
        }
    }

//    @Modifying
//    @Transactional
    @PostMapping("/removeWorker")
    public String removeWorker(@RequestParam(name = "removeWorker", defaultValue = "") String workerName/*WHAT TO INPUT HERE*/){
            System.out.println("Removed this worker:" + workerName);
        if (workerName != "") {
            repo3.deleteByWorkerName(workerName);
        } else {
            System.out.println("Cannot remove worker! Missing parameter : 'workerName'.");
        }

        return "removeWorker";
//        Should ideally redirect to admin dashboard
//        return "redirect://adminDashboard";
    }

//    @GetMapping("/admin/addParking")
//    public String addParking(){
//        return "addParking";
//    }
//    @PostMapping("/admin/addParking")
//    public String addParking(@ModelAttribute Parking parking, HttpSession session){
//        repo1.save(parking);
//        session.setAttribute("message", "Parking Added Successfully");
//        return "redirect:/admin";
//    }
//    @GetMapping("/admin/addWorker")
//    public String addWorker(){
//        return "addWorker";
//    }
//    @PostMapping("/admin/addWorker")
//    public String addWorker(@ModelAttribute Worker worker, HttpSession session){
//        repo2.save(worker);
//        session.setAttribute("message", "Worker Added Successfully");
//        return "redirect:/admin";
//    }


}
