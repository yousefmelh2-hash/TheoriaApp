package com.example.yousef;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practice extends AppCompatActivity {
private Boolean doneFirstQuestion=false;
private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
       initComponents();
       setListeners();
    }

    private void setListeners() {
    }

    private void initComponents() {
    }
}