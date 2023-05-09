package com.example.bookingfunctionality.api.response;

import com.example.bookingfunctionality.models.Halts;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusStopsResponse {
    @SerializedName("result")
    private List<Halts> result;

    @SerializedName("success")
    private Boolean success;

    @SerializedName("status")
    private Integer status;

    public List<Halts> getResult() {
        return result;
    }

    public void setResult(List<Halts> result) {
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
