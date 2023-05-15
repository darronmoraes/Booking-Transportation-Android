package com.example.bookingfunctionality.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingfunctionality.R;
import com.example.bookingfunctionality.models.results.BusScheduleResult;
import com.google.android.material.card.MaterialCardView;

import java.util.List;


public class AvailableBusScheduleAdapter extends RecyclerView.Adapter<AvailableBusScheduleAdapter.ViewHolder> {

    // instances
    List<BusScheduleResult> busScheduleResults;
    Context context;


    public AvailableBusScheduleAdapter(List<BusScheduleResult> busScheduleResults, Context context) {
        this.busScheduleResults = busScheduleResults;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.available_bus_schedule_item,
                        parent,
                        false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvBusRegNum.setText(busScheduleResults.get(holder.getAdapterPosition()).getBus().getRegistrationNumber());
        holder.tvBusType.setText(busScheduleResults.get(holder.getAdapterPosition()).getBus().getType());
        holder.tvSource.setText(busScheduleResults.get(holder.getAdapterPosition()).getRoute().getSource());
        holder.tvDestination.setText(busScheduleResults.get(holder.getAdapterPosition()).getRoute().getDestination());
//        String date = busScheduleResults.get(position).getSchedule().getDate();
        holder.tvDate.setText(busScheduleResults.get(holder.getAdapterPosition()).getSchedule().getDate());
        // seat-available is of type Integer so to hold it in TextView we need to convert it to String.valueOf()
        holder.tvSeatsAvailable.setText(String.valueOf(busScheduleResults.get(holder.getAdapterPosition()).getSchedule().getAvailableSeats()));
        holder.tvFare.setText(busScheduleResults.get(holder.getAdapterPosition()).getRoute().getFare());
    }

    @Override
    public int getItemCount() {
        return busScheduleResults.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Views
        TextView tvBusRegNum, tvBusType, tvSource, tvDestination, tvDate, tvSeatsAvailable, tvFare;
//        CardView MaterialCardView;
        MaterialCardView MaterialCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initialize views
            initViews(itemView);
        }

        public void initViews(View view) {
            // CardView init
            MaterialCardView = view.findViewById(R.id.cardView_bus_schedule);

            // TextView init
            tvBusRegNum = view.findViewById(R.id.textView_bus_reg_no);
            tvBusType = view.findViewById(R.id.textView_bus_type);
            tvSource = view.findViewById(R.id.textView_source);
            tvDestination = view.findViewById(R.id.textView_destination);
            tvDate = view.findViewById(R.id.textView_date);
            tvSeatsAvailable = view.findViewById(R.id.tv_seats_available);
            tvFare = view.findViewById(R.id.textView_fare);
        }
    }
}
