package com.cloudinary.cloudinarysampleapp.main.delivery.usecases.inner.conditional;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.databinding.ConditionalProductBadgingBinding;
import com.cloudinary.transformation.Layer;

public class ConditionalProductBadgingFragment extends Fragment {
    ConditionalProductBadgingBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = ConditionalProductBadgingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setImages();
    }

    private void setImages() {
        ImageView topTopLeft = binding.imageviewTopLeft;
        ImageView topTopRight = binding.imageviewTopRight;
        ImageView bottom = binding.imageviewBottom;
        Glide.with(topTopLeft).load(MediaManager.get().url().generate("Group_15_jda5ms")).into(topTopLeft);
        Glide.with(topTopRight).load(MediaManager.get().url().generate("tshirt4_1_si0swc")).into(topTopRight);
        Glide.with(bottom).load(MediaManager.get().url().transformation(new Transformation()
                .overlay("Group_15_jda5ms")
                .gravity("north_west")
                .width(0.4)
                .x(10)
                .y(10)).generate("tshirt4_1_si0swc")).into(bottom);
    }
}
