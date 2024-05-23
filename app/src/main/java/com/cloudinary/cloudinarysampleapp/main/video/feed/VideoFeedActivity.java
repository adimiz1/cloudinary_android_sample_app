package com.cloudinary.cloudinarysampleapp.main.video.feed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;


import java.util.ArrayList;
import java.util.List;

public class VideoFeedActivity extends AppCompatActivity {
    private com.cloudinary.cloudinarysampleapp.databinding.ActivityVideoFeedBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = com.cloudinary.cloudinarysampleapp.databinding.ActivityVideoFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setViewPager();
    }

    private void setViewPager() {
        List<String> videoUrls = new ArrayList<>();
        videoUrls.add("https://res.cloudinary.com/mobiledemoapp/video/upload/w_1000,q_auto/sprort-2_zgsr5k.mp4");
        videoUrls.add("https://res.cloudinary.com/mobiledemoapp/video/upload/w_1000,q_auto/fashion-2_ewukga.mp4");
        videoUrls.add("https://res.cloudinary.com/mobiledemoapp/video/upload/w_1000,q_auto/fashion-1_1_kuwihy.mp4");
        @SuppressLint("UnsafeOptInUsageError") VideoFeedAdapter videoFeedAdapter = new VideoFeedAdapter(this, videoUrls);
        binding.viewPager.setAdapter(videoFeedAdapter);
    }
}
