package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class BeginnerMeditationActivity extends AppCompatActivity {

    private CardView clothingCard,exerciseCard,stressCard,helloCard;
    private VideoView videoView;
    private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginer_meditation);

        clothingCard = findViewById(R.id.clothingCard);


        clothingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playVideo(R.raw.basic1);
            }
        });

        exerciseCard = findViewById(R.id.exerciseCard);

        exerciseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic2);
            }
        });

        stressCard = findViewById(R.id.stressCard);

        stressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic3);
            }
        });

        helloCard = findViewById(R.id.helloCard);

        helloCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo(R.raw.basic4);
            }
        });
    }

    private void playVideo(int videoId) {
        setContentView(R.layout.activity_video_player);
        videoView = findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://"+ getPackageName()+ "/" + videoId);
        videoView.setVideoURI(uri);
        videoView.start();

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);}


}
