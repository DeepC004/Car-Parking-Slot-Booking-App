package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker findByWorkerName(String worker_name);
    void deleteByWorkerName(String worker_name);
}
