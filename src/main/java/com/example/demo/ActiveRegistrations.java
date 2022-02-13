package com.example.demo;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activeregistrations")
public class ActiveRegistrations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int active_id;

    // NEWLY ADDED
    @Column
    private String parkingLocation;

//    @Column(nullable = false, length = 45)
    @Column(length = 45)
    private int checkin;

//    @Column(nullable = false, length = 64)
    @Column(length = 64)
    private int checkout;

//    @Column
    @Column(nullable = false)
    private Date active_date;

//    @Column(nullable = false)
    @Column
    private int active_parkslot;

//    @Column(nullable = false)
    @Column
    private String car_model;

//    @Column(name = "car_plate", nullable = false, unique = true)
    @Column(name = "car_plate", unique = true)
    private String carPlate;

    @Column
    private String carWash;

    @Column
    private String windowCleaning;

    @Column
    private String carVacuum;

    @Column
    private String pricePerHour;

    @Column
    private String airPressureCheck;

    public String getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

    public String getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(String pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarWash() {
        return carWash;
    }

    public String getWindowCleaning() {
        return windowCleaning;
    }

    public String getCarVacuum() {
        return carVacuum;
    }

    public String getAirPressureCheck() {
        return airPressureCheck;
    }

    public void setCarWash(String carWash) {
        this.carWash = carWash;
    }

    public void setWindowCleaning(String windowCleaning) {
        this.windowCleaning = windowCleaning;
    }

    public void setCarVacuum(String carVacuum) {
        this.carVacuum = carVacuum;
    }

    public void setAirPressureCheck(String airPressureCheck) {
        this.airPressureCheck = airPressureCheck;
    }



//    @OneToMany(targetEntity=Parking.class,cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "active_parkinglocation", referencedColumnName = "parking_id")
//    private List<Parking> parking = new ArrayList<>();
//
//    @OneToMany(targetEntity=User.class,cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "active_user", referencedColumnName = "user_id")
//    private List<User> user = new ArrayList<>();

//    public List<Parking> getParking() {
//        return parking;
//    }
//
//    public void setParking(List<Parking> parking) {
//        this.parking = parking;
//    }
//
//    public List<User> getUser() {
//        return user;
//    }
//
//    public void setUser(List<User> user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "ActiveRegistrations{" +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", active_date=" + active_date +
                ", active_parkslot=" + active_parkslot +
                ", car_model='" + car_model + '\'' +
                ", carPlate='" + carPlate + '\'' +
                ", carWash='" + carWash + '\'' +
                ", windowCleaning='" + windowCleaning + '\'' +
                ", carVacuum='" + carVacuum + '\'' +
                ", pricePerHour='" + pricePerHour + '\'' +
                ", airPressureCheck='" + airPressureCheck + '\'' +
                '}';
    }

//    public int getActive_id() {
//        return active_id;
//    }
//
//    public void setActive_id(int active_id) {
//        this.active_id = active_id;
//    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getCheckout() {
        return checkout;
    }

    public void setCheckout(int checkout) {
        this.checkout = checkout;
    }

    public Date getActive_date() {
        return active_date;
    }

    public void setActive_date(Date active_date) {
        this.active_date = active_date;
    }

    public int getActive_parkslot() {
        return active_parkslot;
    }

    public void setActive_parkslot(int active_parkslot) {
        this.active_parkslot = active_parkslot;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getCar_plate() {
        return carPlate;
    }

    public void setCar_plate(String car_plate) {
        this.carPlate = car_plate;
    }
//
//    public Parking getParking() {
//        return parking;
//    }
//
//    public void setParking(Parking parking) {
//        this.parking = parking;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
