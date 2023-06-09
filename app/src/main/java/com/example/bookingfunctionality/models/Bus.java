package com.example.bookingfunctionality.models;

import com.google.gson.annotations.SerializedName;

public class Bus {

    @SerializedName("id")
    private Integer id;
    @SerializedName("reg-no")
    private String registrationNumber;
    @SerializedName("type")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
