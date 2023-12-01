package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class BreathingActivity extends AppCompatActivity {

    CardView clothingCard,electronicCard,exerciseCard,mapCard,stressCard,musicCard;

    private VideoView videoView;

    private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        clothingCard = findViewById(R.id.clothingCard);

        clothingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.pursedlip);
            }
        });

        electronicCard = findViewById(R.id.electronicCard);

        electronicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic2);
            }
        });

        exerciseCard = findViewById(R.id.exerciseCard);

        exerciseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic3);
            }
        });

        mapCard = findViewById(R.id.MapCard);

        mapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic4);
            }
        });

        stressCard = findViewById(R.id.stressCard);

        stressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic5);
            }
        });

        musicCard = findViewById(R.id.musicCard);

        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic6);
            }
        });
    }

    private void playVideo(int videoId) {
        setContentView(R.layout.activity_video_player);
        videoView = findViewById(R.id.videoView);

        // Set the video URI based on the resource ID
        Uri uri = Uri.parse("android.resource://"+ getPackageName()+ "/" + videoId);
        videoView.setVideoURI(uri);
        videoView.start();

        // Create and set media controller for the video view
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);}
}