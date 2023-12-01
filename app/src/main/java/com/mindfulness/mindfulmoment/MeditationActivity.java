package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MeditationActivity extends AppCompatActivity {

    CardView imageCard,videoCard,audioCard,docCard,downloadCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        ImageSlider imageSlider =findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.meditation1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.meditation2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.meditaion3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.meditation4, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        imageCard = findViewById(R.id.imageCard);
        videoCard =findViewById(R.id.videoCard);
        audioCard = findViewById(R.id.audioCard);
        docCard = findViewById(R.id.docCard);
        downloadCard = findViewById(R.id.downloadCard);

        imageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeditationActivity.this, BeginnerMeditationActivity.class);
                startActivity(intent);
            }
        });

        videoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeditationActivity.this,IntermediateMeditationActivity.class);
                startActivity(intent);
            }
        });

        audioCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeditationActivity.this,AdvanceMeditationActivity.class);
                startActivity(intent);
            }
        });

        docCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeditationActivity.this,BenefitActivity.class);
                startActivity(intent);
            }
        });

        downloadCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeditationActivity.this,MoreDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}