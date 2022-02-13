package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workerdata")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int worker_id;

    @Column(name = "worker_name", unique = true)
    private String workerName;

    @Column
    private int worker_in;

    @Column
    private int worker_out;

    @Column
    private float worker_rating;

//    @OneToMany(targetEntity=Parking.class,cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "worker_location", referencedColumnName = "parking_id")
//            private List<Parking> parking = new ArrayList<>();
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "worker_location", referencedColumnName = "parking_id")
//    private Parking parking;



    public String getWorker_name() {
        return workerName;
    }

    public void setWorker_name(String worker_name) {
        this.workerName = worker_name;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getWorker_in() {
        return worker_in;
    }

    public void setWorker_in(int worker_in) {
        this.worker_in = worker_in;
    }

    public int getWorker_out() {
        return worker_out;
    }

    public void setWorker_out(int worker_out) {
        this.worker_out = worker_out;
    }

    public float getWorker_rating() {
        return worker_rating;
    }

    public void setWorker_rating(float worker_rating) {
        this.worker_rating = worker_rating;
    }

//    public Parking getParking() {

//    public List<Parking> getParking() {
//        return parking;
//    }
//
//    public void setParking(List<Parking> parking) {
//        this.parking = parking;
    }
//        return parking;
//    }
//
//    public void setParking(Parking parking) {
//        this.parking = parking;


