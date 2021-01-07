package com.example.cleantime.home;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cleantime.R;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

public class SchedulePickupActivity extends AppCompatActivity {

    private CollapsibleCalendar datePickerTimeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_pickup);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initViews() {
        datePickerTimeline = findViewById(R.id.datePickerTimeline);

//        datePickerTimeline.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//
//            }
//        });

        datePickerTimeline.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDaySelect() {

            }

            @Override
            public void onItemClick(View v) {

            }

            @Override
            public void onDataUpdate() {

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int position) {

            }
        });



    }

}