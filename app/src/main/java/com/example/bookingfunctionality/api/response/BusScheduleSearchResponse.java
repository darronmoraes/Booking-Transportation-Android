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


    public List<BusScheduleResult> getResult() {
        return result;
    }

    public void setResult(List<BusScheduleResult> result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
