package com.example.yousef;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NameInput extends AppCompatActivity {
Button continueButton;
EditText nameEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nameinput);
        initComponents();
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEt.getText().toString();
                Toast.makeText(NameInput.this, "Welcome"+name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComponents() {
        continueButton=findViewById(R.id.continueButton);
        nameEt=findViewById(R.id.nameEt);
    }
}