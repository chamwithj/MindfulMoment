package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AnxiousActivity extends AppCompatActivity {

    public static int SPLASH_TIMER = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anxious);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AnxiousActivity.this,ExerciseActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER );
    }
}