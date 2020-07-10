package com.example.redalert;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Physio extends AppCompatActivity {
    Button appointment, appointment1,appointment2, appointment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physio);

        appointment = findViewById(R.id.button3);
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Physio.this, Appointment.class);
                startActivity(intent1);

            }});

        appointment1 = findViewById(R.id.app1);
        appointment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Physio.this, Appointment.class);
                startActivity(intent1);

            }});

        appointment2 = findViewById(R.id.app2);
        appointment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Physio.this, Appointment.class);
                startActivity(intent1);

            }});

        appointment3 = findViewById(R.id.app3);
        appointment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Physio.this, Appointment.class);
                startActivity(intent1);

            }});

    }
}