package com.example.landmarkbookjava;

import java.io.Serializable;
import java.util.ArrayList;

public class LandMark implements Serializable {  // Serializable: to pass data between activities

    String name;
    String country;
    int image;
    String content;

    public LandMark(String name, String country, int image, String content) {
        this.name = name;
        this.country = country;
        this.image = image;
        this.content = content;
    }

}
