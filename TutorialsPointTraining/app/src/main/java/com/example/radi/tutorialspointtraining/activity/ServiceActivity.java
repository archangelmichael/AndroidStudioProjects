package com.example.radi.tutorialspointtraining.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.radi.tutorialspointtraining.R;
import com.example.radi.tutorialspointtraining.service.BasicService;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartService(v);
            }
        });

        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStopService(v);
            }
        });
    }

    public void onStartService(View view) {
        startService(new Intent(getBaseContext(), BasicService.class));
    }

    // Method to stop the service
    public void onStopService(View view) {
        stopService(new Intent(getBaseContext(), BasicService.class));
    }
}
