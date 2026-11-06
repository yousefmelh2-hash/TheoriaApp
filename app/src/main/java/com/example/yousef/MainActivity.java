package com.example.yousef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btnTrain, btnStats, btnAboutMe, btnContactMe, btnSimulation, btnSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        btnContactMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ContactMeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        btnSettings=findViewById(R.id.btnSettings);
        btnTrain=findViewById(R.id.btnTrain);
        btnStats=findViewById(R.id.btnStats);
        btnAboutMe=findViewById(R.id.btnAboutMe);
        btnContactMe=findViewById(R.id.btnContactMe);
        btnSimulation=findViewById(R.id.btnSimulation);
    }
}