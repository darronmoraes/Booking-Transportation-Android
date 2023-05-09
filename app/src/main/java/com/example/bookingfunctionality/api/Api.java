package com.example.bookingfunctionality.api;

import com.example.bookingfunctionality.Consts;
import com.example.bookingfunctionality.api.response.BusScheduleSearchResponse;
import com.example.bookingfunctionality.api.response.BusStopsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    // get halts
    @GET(Consts.ENDPOINT_BUS_STOPS)
    Call<BusStopsResponse> getBusStops();

    // get available buses on search
    @GET(Consts.ENDPOINT_SEARCH_BUS)
    Call<BusScheduleSearchResponse> getAllAvailableBuses(@Query("source") Integer sourceId,
                                                         @Query("destination") Integer destinationId,
                                                         @Query("date") String date);

}
