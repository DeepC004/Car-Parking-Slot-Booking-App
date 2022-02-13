package com.example.demo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "slotdata")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slot_id;

    @Column
    @NotNull
    private int slot_time;

    @Column
    @NotNull
    private Date slot_date;

    @Column
    @NotNull
    private int spaces_remaining;

//    @OneToMany(targetEntity=Parking.class,cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "slot_location", referencedColumnName = "parking_id")
//    private List<Parking> parking = new ArrayList<>();


    @Override
    public String toString() {
        return "Slot{" +
                "slot_id=" + slot_id +
                ", slot_time=" + slot_time +
                ", slot_date=" + slot_date +
                ", spaces_remaining=" + spaces_remaining +
//                ", parking=" + parking +
                '}';
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public int getSlot_time() {
        return slot_time;
    }

    public void setSlot_time(int slot_time) {
        this.slot_time = slot_time;
    }

    public Date getSlot_date() {
        return slot_date;
    }

    public void setSlot_date(Date slot_date) {
        this.slot_date = slot_date;
    }

    public int getSpaces_remaining() {
        return spaces_remaining;
    }

    public void setSpaces_remaining(int spaces_remaining) {
        this.spaces_remaining = spaces_remaining;
    }

//    public Parking getParking() {
//        return parking;
//    }
//
//    public void setParking(Parking parking) {

//    public List<Parking> getParking() {
//        return parking;
//    }
//
//    public void setParking(List<Parking> parking) {
//        this.parking = parking;
//    }
//        this.parking = parking;
//    }
}
