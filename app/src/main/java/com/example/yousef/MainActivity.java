package com.example.yousef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button btnPractice, btnStats,  btnSimulation, btnSettings;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setListeners();
    }

    private void setListeners() {

        btnSimulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(MainActivity.this, ChoosePracticeType.class);
                startActivity(intent);
            }
        });
        btnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(MainActivity.this, TimeSettingForExam.class);
                startActivity(intent);
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(MainActivity.this, Statistics.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        btnSettings=findViewById(R.id.btnSettings);
        btnPractice =findViewById(R.id.btnTrain);
        btnStats=findViewById(R.id.btnStats);
        btnSimulation=findViewById(R.id.btnSimulation);
    }
}