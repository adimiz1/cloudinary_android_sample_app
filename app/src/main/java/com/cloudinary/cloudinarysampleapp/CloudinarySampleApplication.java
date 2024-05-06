package com.cloudinary.cloudinarysampleapp;

import android.app.Application;

import com.cloudinary.android.MediaManager;
import com.cloudinary.utils.Analytics;

import java.util.HashMap;
import java.util.Map;

public class CloudinarySampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initMediaManager();
    }

    private void initMediaManager() {
        Map config = new HashMap();
        config.put("cloud_name", "mobiledemoapp");
        config.put("secure", true);
        MediaManager.init(this, config);
    }
}