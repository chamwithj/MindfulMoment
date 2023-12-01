package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // Declare card views for different functionalities
    CardView clothingCard,electronicCard,exerciseCard,mapCard,stressCard,musicCard,todoCard;

    // Declare sensor-related variables
    Sensor sensor;
    SensorManager sensorManager;

    // Declare media player to play audio
    MediaPlayer mp;
    boolean isRunning = false;

    // Declare night mode switch and related preferences
    SwitchCompat switchMode;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Assign card views to their variables
        clothingCard = findViewById(R.id.clothingCard);
        electronicCard = findViewById(R.id.electronicCard);
        exerciseCard = findViewById(R.id.exerciseCard);
        mapCard = findViewById(R.id.MapCard);
        stressCard = findViewById(R.id.stressCard);
        musicCard = findViewById(R.id.musicCard);


        // Set click listeners for each card view
        clothingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MeditationActivity.class);
                startActivity(intent);
            }
        });

        electronicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BreathingActivity.class);
                startActivity(intent);
            }
        });

        exerciseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });

        mapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        stressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StressActivity.class);
                startActivity(intent);
            }
        });

        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MusicActivity.class);
                startActivity(intent);
            }
        });

        todoCard = findViewById(R.id.todoCard);
        todoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TodoActivity.class);
                startActivity(intent);
            }
        });

        // Assign switch view and handle night mode
        switchMode = findViewById(R.id.switchMode);

        // Retrieve night mode preference value
        sharedPreferences = getSharedPreferences("MODE",Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("nightMode",false);

        if(nightMode){
            switchMode.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nightMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode",false);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode",true);
                }
                editor.apply();
            }
        });

        // Get the sensor service and assign the light sensor
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }
    @Override
    protected void onResume() {
        super.onResume();
        // Register the sensor listener with the light sensor and set the delay
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the sensor listener when the activity is paused
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Handle sensor changes (specifically, the light sensor)
        if(sensorEvent.values[0]>99 && isRunning==false){
            isRunning=true;
            mp=new MediaPlayer();
            try {
                // Set the data source to the audio file and start playing it
                mp.setDataSource(this, Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.relaxing));
                mp.prepare();
                mp.start();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}