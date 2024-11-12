package com.example.sh_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.sh_project.fuctions.alarm;
import com.example.sh_project.fuctions.cctv;
import com.example.sh_project.fuctions.surveillance;
import com.example.sh_project.fuctions.temperature;

public class function extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        // 실시간 CCTV 버튼
        ImageButton realtimeCCTVButton = findViewById(R.id.realtimeCCTVButton);
        realtimeCCTVButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function.this, cctv.class);
                startActivity(intent);
            }
        });

        // 알람 및 예약 버튼
        ImageButton alarmReservationButton = findViewById(R.id.alarmReservationButton);
        alarmReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function.this, alarm.class);
                startActivity(intent);
            }
        });

        // 감시 모드 활성화 버튼
        ImageButton surveillanceModeButton = findViewById(R.id.surveillanceModeButton);
        surveillanceModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function.this, surveillance.class);
                startActivity(intent);
            }
        });

        // 온습도 확인 버튼
        ImageButton temperatureCheckButton = findViewById(R.id.temperatureCheckButton);
        temperatureCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(function.this, temperature.class);
                startActivity(intent);
            }
        });
    }
}
