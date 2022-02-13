package com.example.demo;

import javax.persistence.*;


@Entity
@Table(name = "userdata")
public class User {

    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "role")
    private String role = "USER";

    @Column(nullable = false)
    private boolean iscurrentlyparked = false;

    @Column(nullable = false, length = 45)
    private int parked_hours = 0;

    @Id
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 45)
    private String phone;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parking.parking_id")
//    private Parking parking;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
//    private List<Parking> listActive = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getIscurrentlyparked() {
        return iscurrentlyparked;
    }

    public void setIscurrentlyparked(boolean iscurrentlyparked) {
        this.iscurrentlyparked = iscurrentlyparked;
    }

    public int getParked_hours() {
        return parked_hours;
    }

    public void setParked_hours(int parked_hours) {
        this.parked_hours = parked_hours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}