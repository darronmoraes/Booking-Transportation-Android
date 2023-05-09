package com.example.bookingfunctionality.api.response;

import com.example.bookingfunctionality.models.results.BusScheduleResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusScheduleSearchResponse {
    @SerializedName("results")
    private List<BusScheduleResult> result;

    @SerializedName("success")
    private Boolean success;

    @SerializedName("status")
    private Integer status;
}
