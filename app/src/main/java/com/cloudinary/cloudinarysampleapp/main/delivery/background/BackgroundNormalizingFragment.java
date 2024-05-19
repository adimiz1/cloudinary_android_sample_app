package com.cloudinary.cloudinarysampleapp.main.delivery.background;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.databinding.LocalizationFragmentBinding;
import com.cloudinary.cloudinarysampleapp.helpers.views.RevealImageView;

public class BackgroundNormalizingFragment extends Fragment {

    LocalizationFragmentBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = LocalizationFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRevealImageView();
    }

    private void setRevealImageView() {
        RevealImageView revealImageView = binding.localizationRevealImageview;
        Glide.with(revealImageView).asBitmap().load(MediaManager.get().url().transformation(new Transformation().effect("background_removal")).generate("Demo%20app%20content/layers-fashion-2_1_xsfbvm")).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                revealImageView.setLeftImage(resource);
            }
        });
        Glide.with(revealImageView).asBitmap().load(MediaManager.get().url().generate("Demo%20app%20content/layers-fashion-2_1_xsfbvm")).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                revealImageView.setRightImage(resource);
            }
        });
    }
}
