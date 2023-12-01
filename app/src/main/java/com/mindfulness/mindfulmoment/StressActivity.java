package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StressActivity extends AppCompatActivity {

    public static int SPLASH_TIMER = 7500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StressActivity.this,StressActivity2.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER );
    }
}