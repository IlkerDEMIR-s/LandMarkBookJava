package com.example.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.landmarkbookjava.databinding.ActivityDetailsBinding;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        // get the object from the intent
        // (LandMark) is the type of the object - Casting
        LandMark selectedLandMark = (LandMark) intent.getSerializableExtra("landmark");

        // if you want to use singleton instead of intent
        /*Singleton singleton = Singleton.getInstance();
        LandMark selectedLandMark = singleton.getSentLandMark();*/

        //binding.imageView.setImageBitmap();  // set image from bitmap

        binding.imageView.setImageResource(selectedLandMark.image);
        binding.nameText.setText(selectedLandMark.name);
        binding.countryText.setText(selectedLandMark.country);
        binding.contentTextView.setText(selectedLandMark.content);



    }
}