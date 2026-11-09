package com.example.yousef;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class NameInput extends AppCompatActivity {
Button continueButton;
EditText nameEt;
VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nameinput);
        initComponents();
        startVideo();
        buttonListener();
    }

    private void buttonListener() {
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEt.getText().toString();
                if (name.isEmpty()){
                    if (name.isEmpty()) {
                        nameEt.setError("The item name cannot be empty.");
                        nameEt.requestFocus(); // Brings focus directly to the invalid field
                    }
                }
               else{ Toast.makeText(NameInput.this, "Welcome "+name, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(NameInput.this,MainActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
               }
            }
        });
    }

    private void startVideo() {

        videoView.setVideoURI(Uri.parse(
                "android.resource://" + getPackageName() + "/" + R.raw.vidd
        ));

        videoView.setOnPreparedListener(mp -> { // launch when the video is ready for playing
            mp.setLooping(true);
            videoView.start();
        });
    }

    private void initComponents() {
        continueButton=findViewById(R.id.continueButton);
        nameEt=findViewById(R.id.nameEt);
        videoView=findViewById(R.id.videoView);
    }
}