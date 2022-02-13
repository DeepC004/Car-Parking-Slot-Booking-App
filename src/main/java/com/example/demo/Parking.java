package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "parkingdata")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parking_id;


    @Column(name = "parking_location", nullable = false, unique = true, length = 45)
    private String parkingLocation;

    @Column(nullable = false, length = 64)
    private int available_slots;

    @Column
    private int cost_parking = 25;

    @Column
    private int max_parking_time = 24;

    @Column
    private String airPressureCheck = "on";

    @Column
    private String carWash = "on";

    @Column
    private String windowCleaning = "yes";

    @Column
    private String carVacuum = "yes";

    public String getParkingLocation() {
        return parkingLocation;
    }

    public void setParkinglocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

    public void setParkingLocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

    public String getAirPressureCheck() {
        return airPressureCheck;
    }

    public void setAirPressureCheck(String airPressureCheck) {
        this.airPressureCheck = airPressureCheck;
    }

    public String getCarWash() {
        return carWash;
    }

    public void setCarWash(String carWash) {
        this.carWash = carWash;
    }

    public String getWindowCleaning() {
        return windowCleaning;
    }

    public void setWindowCleaning(String windowCleaning) {
        this.windowCleaning = windowCleaning;
    }

    public String getCarVacuum() {
        return carVacuum;
    }

    public void setCarVacuum(String carVacuum) {
        this.carVacuum = carVacuum;
    }



//    @OneToMany(mappedBy = "parking")
//    private Set<Parking> listUser = new HashSet<>();
//
//    @OneToOne(mappedBy = "parking", cascade = CascadeType.ALL/*,fetch = FetchType.LAZY, orphanRemoval = false*/)
//    private Set<Parking> listWorker = new HashSet<>();
//
//    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL/*,fetch = FetchType.LAZY, orphanRemoval = false*/)
//    private Set<Parking> listSlot = new HashSet<>();
//
//    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL/*,fetch = FetchType.LAZY, orphanRemoval = false*/)
//    private Set<Parking> listActive = new HashSet<>();



    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public int getAvailable_slots() {
        return available_slots;
    }

    public void setAvailable_slots(int available_slots) {
        this.available_slots = available_slots;
    }

    public int getCost_parking() {
        return cost_parking;
    }

    public void setCost_parking(int cost_parking) {
        this.cost_parking = cost_parking;
    }

    public int getMax_parking_time() {
        return max_parking_time;
    }

    public void setMax_parking_time(int max_parking_time) {
        this.max_parking_time = max_parking_time;
    }

//    public Set<Parking> getListUser() {
//        return listUser;
//    }
//
//    public void setListUser(Set<Parking> listUser) {
//        this.listUser = listUser;
//    }
//
//    public Set<Parking> getListWorker() {
//        return listWorker;
//    }
//
//    public void setListWorker(Set<Parking> listWorker) {
//        this.listWorker = listWorker;
//    }
//
//    public Set<Parking> getListSlot() {
//        return listSlot;
//    }
//
//    public void setListSlot(Set<Parking> listSlot) {
//        this.listSlot = listSlot;
//    }
//
//    public Set<Parking> getListActive() {
//        return listActive;
//    }
//
//    public void setListActive(Set<Parking> listActive) {
//        this.listActive = listActive;
//    }
}
