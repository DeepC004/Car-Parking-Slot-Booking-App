package com.example.demo;

public class ParkingDTO {
    private int parking_id;
    private String parkingLocation;
    private int available_slots;
    private int cost_parking = 25;
    private int max_parking_time = 24;
    private String airPressureCheck = "yes";
    private String carWash = "yes";
    private String windowCleaning = "yes";
    private String carVacuum = "yes";


    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public String getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
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

}
