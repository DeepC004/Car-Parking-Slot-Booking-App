package com.example.demo;

import javax.persistence.Column;
import java.util.Date;

public class ActiveRegistrationsDTO {
    private int checkin;
    private int checkout;
    private String active_date;
    private int active_parkslot;

    // newly added
    private String parkingLocation;
    private String car_model;
    private String carPlate;
    private String carWash;
    private String windowCleaning;
    private String carVacuum;
    private String pricePerHour;
    private String airPressureCheck;

    public String getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

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

    public String getActive_date() {
        return active_date;
    }

    public void setActive_date(String active_date) {
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

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
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

    public String getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(String pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getAirPressureCheck() {
        return airPressureCheck;
    }

    public void setAirPressureCheck(String airPressureCheck) {
        this.airPressureCheck = airPressureCheck;
    }


    @Override
    public String toString() {
        return "ActiveRegistrationsDTO{" +
                "checkin=" + checkin +
                ", checkout=" + checkout +
                ", active_date='" + active_date + '\'' +
                ", active_parkslot=" + active_parkslot +
                ", parkingLocation='" + parkingLocation + '\'' +
                ", car_model='" + car_model + '\'' +
                ", carPlate='" + carPlate + '\'' +
                ", carWash='" + carWash + '\'' +
                ", windowCleaning='" + windowCleaning + '\'' +
                ", carVacuum='" + carVacuum + '\'' +
                ", pricePerHour='" + pricePerHour + '\'' +
                ", airPressureCheck='" + airPressureCheck + '\'' +
                '}';
    }
}
