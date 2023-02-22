package com.example.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> landMarkArrayList; // array list of LandMark objects

    private ActivityMainBinding binding;  // binding object for the activity - recycler view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landMarkArrayList = new ArrayList<>();

        String pisaContent = "The Leaning Tower of Pisa or simply the Tower of Pisa (Italian: Torre di Pisa) is the campanile," +
                " or freestanding bell tower, of the cathedral of the Italian city of Pisa, " +
                "known worldwide for its unintended tilt.";
        String eiffelContent = "The Eiffel Tower (French: La tour Eiffel, pronounced [la tuʁ‿ɛfɛl] (About this soundlisten)) " +
                "is an iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, " +
                "whose company designed and built the tower.";
        String colosseumContent = "The Colosseum or Coliseum (Latin: Colosseum, Ancient Greek: Κολοσσαῖον, " +
                "Kolossaión, Italian: Colosseo, pronounced [koˈlɔsseːo]) is an oval amphitheatre in the centre of the city of Rome, " +
                "Italy, just east of the Roman Forum.";
        String londonBridgeContent = "London Bridge is a road and foot traffic bridge over the River Thames in London, " +
                "connecting the City of London and Southwark. It is close to the Tower of London and has been a crossing point since Roman times. ";


        // Data
        LandMark pisa = new LandMark("Pisa", "Italy", R.drawable.pisa, pisaContent);
        LandMark eiffel = new LandMark("Eiffel", "France", R.drawable.eiffel, eiffelContent);
        LandMark colosseum = new LandMark("Colosseum", "Italy", R.drawable.colosseum, colosseumContent);
        LandMark londonBridge = new LandMark("London Bridge", "England", R.drawable.londonbridge, londonBridgeContent);

        // Add to array list
        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(colosseum);
        landMarkArrayList.add(londonBridge);

        //Not efficient
        /*
        Bitmap is a class that can hold image data like jpg, png, etc.
        Intent have a limit of data size when we use bitmap to pass data between activities we can use singleton
        Bitmap pisaBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        */

        // Layout Manager
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this)); // or GradeLayoutManager(this)

        // Adapter

        LandMarkAdapter landMarkAdapter = new LandMarkAdapter(landMarkArrayList);
        binding.recyclerView.setAdapter(landMarkAdapter);

    }


}