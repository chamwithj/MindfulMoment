package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class IntermediateExerciseActivity extends AppCompatActivity {

    private CardView clothingCard,exerciseCard,stressCard,helloCard;

    private VideoView videoView;

    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_exercise);

        clothingCard = findViewById(R.id.clothingCard);


        clothingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntermediateExerciseActivity.this,WorkOutActivity2.class);
                startActivity(intent);
            }
        });

        exerciseCard = findViewById(R.id.exerciseCard);

        exerciseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntermediateExerciseActivity.this,WorkoutActivity.class);
                startActivity(intent);
            }
        });

        stressCard = findViewById(R.id.stressCard);

        stressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntermediateExerciseActivity.this,WorkOutActivity2.class);
                startActivity(intent);
            }
        });

        helloCard = findViewById(R.id.helloCard);

        helloCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntermediateExerciseActivity.this,WorkoutActivity.class);
                startActivity(intent);
            }
        });
    }


}