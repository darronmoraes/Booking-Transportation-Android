package com.example.bookingfunctionality.models;

import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("arrival")
    private String arrival;
    @SerializedName("arrival-stand")
    private String arrivalStand;
    @SerializedName("date")
    private String date;
    @SerializedName("departure")
    private String departure;
    @SerializedName("departure-stand")
    private String departureStand;
    @SerializedName("duration")
    private String duration;
    @SerializedName("id")
    private Integer id;
    @SerializedName("seats-available")
    private Integer availableSeats;

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getArrivalStand() {
        return arrivalStand;
    }

    public void setArrivalStand(String arrivalStand) {
        this.arrivalStand = arrivalStand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureStand() {
        return departureStand;
    }

    public void setDepartureStand(String departureStand) {
        this.departureStand = departureStand;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
