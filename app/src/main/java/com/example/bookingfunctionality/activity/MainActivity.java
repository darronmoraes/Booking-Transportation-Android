package com.example.bookingfunctionality.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bookingfunctionality.R;

public class MainActivity extends AppCompatActivity {

    EditText etSource, etDestination;
    TextView tvDatePicker;
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
    }

    public void initViews() {
        etSource = findViewById(R.id.editText_source_stop);
        etDestination = findViewById(R.id.editText_destination_stop);
        tvDatePicker = findViewById(R.id.textView_datePicker);
        btnSearchBus = findViewById(R.id.button_search_buses_available);

        // Initialize the year, month, and day variables with the current date
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        String currentDate = day + "th " + month + ", " + year;
        tvDatePicker.setText(currentDate);
    }

    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            // set the selected date in the TextView
            String selectedDate = dayOfMonth + " " + (month + 1) + " " + year;
            tvDatePicker.setText(selectedDate);
        }
    };
}