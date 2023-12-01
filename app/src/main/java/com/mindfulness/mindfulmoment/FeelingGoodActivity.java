package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FeelingGoodActivity extends AppCompatActivity {

    public static int SPLASH_TIMER = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_good);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FeelingGoodActivity.this,StressedActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER );
    }
}