package com.example.bookingfunctionality;

public class Consts {

    public static final String IP_ADDRESS = "192.168.140.166";

    // Base urls
    public static final String BASE_URL_BOOKING = "http://" + IP_ADDRESS + ":5000/booking/";
    public static final String BASE_URL_BUS = "http://" + IP_ADDRESS + ":5000/bus/";

    // Endpoints
    public static final String ENDPOINT_BUS_STOPS = "bus-stops";
    public static final String ENDPOINT_SEARCH_BUS = "search";


    // Buttons
    public static final String BUTTON_SEARCH_BUS = "Search buses";


    // location
    public static final Integer LOCATION_THRESHOLD = 50;

    // request codes
    public static final Integer LOCATION_REQUEST_CODE = 1;
}
