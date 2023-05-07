package com.example.bookingfunctionality.api;

import com.example.bookingfunctionality.Consts;
import com.example.bookingfunctionality.api.response.BusStopsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    // get halts
    @GET(Consts.ENDPOINT_BUS_STOPS)
    Call<BusStopsResponse> getBusStops();

}
