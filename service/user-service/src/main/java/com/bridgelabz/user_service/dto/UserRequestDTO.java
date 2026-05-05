package com.bridgelabz.user_service.dto;

public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private String phone;   // ✅ ADD THIS

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {   // ✅ ADD
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}