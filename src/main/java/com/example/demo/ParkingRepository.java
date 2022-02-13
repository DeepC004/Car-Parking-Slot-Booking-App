package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    Parking findByParkingLocation(String parking_location);
    @Modifying
    @Transactional
    void deleteByParkingLocation(String parking_location);
}
