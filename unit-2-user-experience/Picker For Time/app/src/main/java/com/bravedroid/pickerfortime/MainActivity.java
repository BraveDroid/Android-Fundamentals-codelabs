package com.bravedroid.pickerfortime;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment=new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),"timePicker");
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        String hourOfDay_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        String timeMessage = (hourOfDay_string + ":" + minute_string);
        Toast.makeText(this,"Time is :"+ timeMessage, Toast.LENGTH_SHORT).show();
    }
}
