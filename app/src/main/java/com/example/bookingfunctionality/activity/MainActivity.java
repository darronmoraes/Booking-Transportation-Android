package com.example.bookingfunctionality.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bookingfunctionality.Consts;
import com.example.bookingfunctionality.R;
import com.example.bookingfunctionality.fragments.DestinationSearchFrag;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity {

    EditText etSource, etDestination;
    TextView tvDatePicker, activityTitle;
    Button btnSearchBus;

    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        tvDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        etDestination.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DestinationSearchFrag frag = new DestinationSearchFrag();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout_booking, frag);
                transaction.commit();

                // hide views
                hideViewsOnFragTransaction();
            }
        });
    }

    public void initViews() {
        activityTitle = findViewById(R.id.textView_searchBus_activityTitle);
        etSource = findViewById(R.id.editText_source_stop);
        etDestination = findViewById(R.id.editText_destination_stop);
        tvDatePicker = findViewById(R.id.textView_datePicker);
        btnSearchBus = findViewById(R.id.button_search_buses_available);

        btnSearchBus.setText(Consts.BUTTON_SEARCH_BUS);

        // Initialize the year, month, and day variables with the current date
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDatePicker.setText(getCurrentDate(year, month, day));

        etDestination.setInputType(InputType.TYPE_NULL);    // disables keyboard input
    }

    public void hideViewsOnFragTransaction() {
        // Hide the views in the current activity
        etSource.setVisibility(View.GONE);
        etDestination.setVisibility(View.GONE);
        tvDatePicker.setVisibility(View.GONE);
        btnSearchBus.setVisibility(View.GONE);
        activityTitle.setVisibility(View.GONE);
    }

    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            // get the month name
            String monthName = "";
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
            String[] months = dateFormatSymbols.getMonths();

            if (month >= 0 && month <= 11) {
                monthName = months[month];
            }

            // set the selected date in the TextView
            String selectedDate = dayOfMonth + " " + monthName + ", " + year;

            tvDatePicker.setText(selectedDate);
        }
    };

    private String getCurrentDate(int year, int month, int day) {
        String monthName = "";
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        String[] months = dateFormatSymbols.getMonths();

        if (month >= 0 && month <= 11) {
            monthName = months[month];
        }

        return day + " " + monthName + ", " + year;
    }
}