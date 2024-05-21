package com.cloudinary.cloudinarysampleapp.main.delivery.usecases.inner.normalize;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.databinding.NormalizeAssetSizingBinding;

public class NormalizeAssetSizingFragment extends Fragment {
    NormalizeAssetSizingBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = NormalizeAssetSizingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setImages();
    }

    private void setImages() {
        ImageView topTopLeft = binding.topImageviewTopLeft;
        ImageView topTopRight = binding.topImageviewTopRight;
        ImageView topBottomRight = binding.topImageviewBottomRight;
        ImageView bottomLeft = binding.bottomImageviewLeft;
        ImageView bottomMiddle = binding.bottomImageviewCenter;
        ImageView bottomRight = binding.bottomImageviewRight;
        Glide.with(topTopLeft).load(MediaManager.get().url().generate("pexels-aditya-aiyar-1407354_tiw4bv")).into(topTopLeft);
        Glide.with(topTopRight).load(MediaManager.get().url().generate("pexels-mnz-1670766_n9hfoi")).into(topTopRight);
        Glide.with(topBottomRight).load(MediaManager.get().url().generate("pexels-wendy-wei-12511453_b4shho")).into(topBottomRight);
        Glide.with(bottomLeft).load(MediaManager.get().url().generate("Rectangle_1434_fcnobi")).into(bottomLeft);
        Glide.with(bottomMiddle).load(MediaManager.get().url().generate("Rectangle_1435_mwtszu")).into(bottomMiddle);
        Glide.with(bottomRight).load(MediaManager.get().url().generate("Rectangle_1436_kdsfld")).into(bottomRight);
    }
}
