package com.cloudinary.cloudinarysampleapp;

import android.app.Application;

import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.helpers.CloudinaryHelper;
import com.cloudinary.cloudinarysampleapp.local_storage.AssetRepository;
import com.cloudinary.utils.Analytics;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;
import java.util.Map;


public class CloudinarySampleApplication extends Application {
    private AssetRepository assetRepository;
    public static String APP_NAME = "cloudinary_sample_app";
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        assetRepository = AssetRepository.getInstance(this);
    }

    public AssetRepository getAssetRepository() {
        return assetRepository;
    }


}