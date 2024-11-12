package com.example.sh_project;

public class SignUpRequest {
    String name;
    String phone;
    String username;
    String password;
    String raspberryPiId;

    public SignUpRequest(String name, String phone, String username, String password, String raspberryPiId) {
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.raspberryPiId = raspberryPiId;
    }

    // Getters 및 Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public String getRaspberryPiId() {
        return raspberryPiId;
    }

    public void setRaspberryPiId(String raspberryPiId) {
        this.raspberryPiId = raspberryPiId;
    }
}
