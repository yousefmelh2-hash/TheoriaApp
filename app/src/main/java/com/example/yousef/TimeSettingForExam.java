package com.example.yousef;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TimeSettingForExam extends AppCompatActivity {
    Button btnCustomTime, btnContinue, btn40mins, btn20mins, btn10mins, btn15mins;
    int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_setting_for_exam);
        initComponents();
        setListeners();
    }

    private void setListeners() {
        btnCustomTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimeDialog();
            }
        });
    }

    private void openTimeDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_set_time, null);
        NumberPicker minutePicker = dialogView.findViewById(R.id.dialogNumberPicker);

        minutePicker.setMinValue(8);
        minutePicker.setMaxValue(60);    // Set minimum and maximum minutes
        minutePicker.setValue(40);
        new AlertDialog.Builder(this)
                .setView(dialogView)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Save", (dialog, which) -> {
                    minutePicker.clearFocus(); //מכריחה את ה-NumberPicker לסיים את מצב ההקלדה ולנעול את המספר.
                       // Default to 40 mins
                    int selectedTime = minutePicker.getValue();
                    onTimeSelected(selectedTime); // we put the time in a method to save it class
                    Toast.makeText(this, "Selected time: " + selectedTime + " minutes", Toast.LENGTH_SHORT).show();
                })
                .show();
    }
    private void onTimeSelected(int minutes) {
        time = minutes;
    }
    private void initComponents() {
        btnCustomTime = findViewById(R.id.btnCustomTime);
        btnContinue = findViewById(R.id.btnContinue);
        btn40mins = findViewById(R.id.btn40mins);
        btn20mins = findViewById(R.id.btn20mins);
        btn10mins= findViewById(R.id.btn10mins);
        btn15mins= findViewById(R.id.btn15mins);

    }

}