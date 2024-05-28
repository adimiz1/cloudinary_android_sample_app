package com.cloudinary.cloudinarysampleapp;

import android.app.Application;

import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.helpers.CloudinaryHelper;
import com.cloudinary.utils.Analytics;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;
import java.util.Map;

public class CloudinarySampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CloudinaryHelper.setMediaManager(this, "mobiledemoapp");
        Fresco.initialize(this);
    }
}