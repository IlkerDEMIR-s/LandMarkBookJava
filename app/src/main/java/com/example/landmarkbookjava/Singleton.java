package com.example.landmarkbookjava;

import android.graphics.Bitmap;

public class Singleton {  // Optional Singleton class

    private LandMark sentLandMark;
    private static Singleton singleton;

    //private Bitmap selectedImage;

    private Singleton() {

    }

    public LandMark getSentLandMark() {
        return sentLandMark;
    }

    public void setSentLandMark(LandMark sentLandMark) {
        this.sentLandMark = sentLandMark;
    }

    public static Singleton getInstance() {
        if (singleton == null) { // if there is no instance, create one
            singleton = new Singleton();
        }
        return singleton;  // return the instance
    }


}
