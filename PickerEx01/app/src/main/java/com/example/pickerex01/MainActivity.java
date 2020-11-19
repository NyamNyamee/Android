package com.example.pickerex01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText dateET, timeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateET = findViewById(R.id.dateET);
        timeET = findViewById(R.id.timeET);
    }

    public void setDate(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);

        // 선택시 작동할 리스너(컨텍스트, 리스너, 년, 월, 일)
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateET.setText(String.format("%04d년 %02d월 %02d일", year, month + 1, dayOfMonth));
            }
        }, year, month, date).show();
    }

    public void setTime(View view) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        // 선택시 작동할 리스너(컨텍스트, 리스너, 시, 분, 24시표기법)
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeET.setText(String.format("%02d시 %02d분", hourOfDay, minute));
            }
        }, hour, minute, true).show();
    }
}