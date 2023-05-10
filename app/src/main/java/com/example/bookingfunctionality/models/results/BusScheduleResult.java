package com.example.bookingfunctionality.models.results;

import com.example.bookingfunctionality.models.Bus;
import com.example.bookingfunctionality.models.Route;
import com.example.bookingfunctionality.models.Schedule;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusScheduleResult {

    @SerializedName("bus")
    Bus bus;
    @SerializedName("route")
    Route route;
    @SerializedName("schedule")
    Schedule schedule;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
