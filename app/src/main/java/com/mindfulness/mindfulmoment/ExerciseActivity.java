package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExerciseActivity extends AppCompatActivity {

    CardView imageCard,videoCard,audioCard,docCard,downloadCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        imageCard = findViewById(R.id.imageCard);
        videoCard =findViewById(R.id.videoCard);
        audioCard = findViewById(R.id.audioCard);
        docCard = findViewById(R.id.docCard);
        downloadCard = findViewById(R.id.downloadCard);

        imageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseActivity.this, BeginnerExerciseActivity.class);
                startActivity(intent);
            }
        });

        videoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseActivity.this, IntermediateExerciseActivity.class);
                startActivity(intent);
            }
        });

        audioCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseActivity.this,AdvanceExerciseActivity.class);
                startActivity(intent);
            }
        });

        docCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseActivity.this,BenefitActivity.class);
                startActivity(intent);
            }
        });

        downloadCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseActivity.this,MoreDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}