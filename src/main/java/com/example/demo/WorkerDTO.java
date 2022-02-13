package com.example.demo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WorkerDTO {

    private int worker_id;
    private String workerName;
    private float worker_rating;


    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public float getWorker_rating() {
        return worker_rating;
    }

    public void setWorker_rating(float worker_rating) {
        this.worker_rating = worker_rating;
    }

}
