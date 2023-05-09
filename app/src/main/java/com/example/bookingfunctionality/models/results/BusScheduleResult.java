package com.example.bookingfunctionality.models.results;

import com.example.bookingfunctionality.models.Bus;
import com.example.bookingfunctionality.models.Route;
import com.example.bookingfunctionality.models.Schedule;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusScheduleResult {

    @SerializedName("bus")
    List<Bus> bus;
    @SerializedName("route")
    List<Route> route;
    @SerializedName("schedule")
    List<Schedule> schedule;

    public List<Bus> getBus() {
        return bus;
    }

    public void setBus(List<Bus> bus) {
        this.bus = bus;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}
