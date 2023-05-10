package com.example.bookingfunctionality.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingfunctionality.Consts;
import com.example.bookingfunctionality.R;
import com.example.bookingfunctionality.adapters.AvailableBusScheduleAdapter;
import com.example.bookingfunctionality.api.Client;
import com.example.bookingfunctionality.api.response.BusScheduleSearchResponse;
import com.example.bookingfunctionality.models.results.BusScheduleResult;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableBusScheduleFragment extends Fragment {

    // Instances
    RecyclerView recyclerViewAvailableBusSchedules;

    // List of bus schedules
    List<BusScheduleResult> busScheduleResultsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_available_bus_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

        getAvailableBusSchedules();
    }

    public void initViews(View view) {
        // recycler view initialization
        recyclerViewAvailableBusSchedules = view.findViewById(R.id.recyclerView_available_bus_schedules);
        recyclerViewAvailableBusSchedules.setHasFixedSize(true);
        recyclerViewAvailableBusSchedules.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getAvailableBusSchedules() {
        Call<BusScheduleSearchResponse> busScheduleSearchResponseCall = Client.getInstance(Consts.BASE_URL_BUS).getRoute().getAllAvailableBuses(getSourceId(), getDestinationId(), getDate());
        Log.i("TAG", "getAvailableBusSchedules: " + getSourceId() + " " + getDestinationId() + " " + getDate());
        busScheduleSearchResponseCall.enqueue(new Callback<BusScheduleSearchResponse>() {
            @Override
            public void onResponse(Call<BusScheduleSearchResponse> call, Response<BusScheduleSearchResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    busScheduleResultsList = response.body().getResult();
                    Log.i("TAG", "onResponse: " + busScheduleResultsList);
                    recyclerViewAvailableBusSchedules.setAdapter(new AvailableBusScheduleAdapter(busScheduleResultsList, getContext()));
                } else {
                    Log.i("TAG", "onResponse: error");
                }
            }

            @Override
            public void onFailure(Call<BusScheduleSearchResponse> call, Throwable t) {
                Log.i("TAG", "onFailure: error " + t.getLocalizedMessage());
            }
        });
    }

    public Integer getSourceId() {
        Bundle data = getArguments();
        if (data != null) {
            return data.getInt("sourceId");
        }
        return null;
    }

    public Integer getDestinationId() {
        Bundle data = getArguments();
        if (data != null) {
            return data.getInt("destinationId");
        }
        return null;
    }

    public String getDate() {
        Bundle data = getArguments();
        if (data != null) {
            return data.getString("date");
        }
        return null;
    }
}