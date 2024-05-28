package com.cloudinary.cloudinarysampleapp.main.widgets.image_widget;

import static java.util.Objects.requireNonNull;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.cloudinary.android.MediaManager;
import com.cloudinary.android.download.fresco.FrescoDownloadRequestBuilderFactory;
import com.cloudinary.android.download.glide.GlideDownloadRequestBuilderFactory;
import com.cloudinary.android.download.picasso.PicassoDownloadRequestBuilderFactory;
import com.cloudinary.cloudinarysampleapp.GlideApp;
import com.cloudinary.cloudinarysampleapp.databinding.ImageWidgetFragmentBinding;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Objects;

public class ImageWidgetFragment extends Fragment {
    ImageWidgetFragmentBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = ImageWidgetFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setImageViews();
    }

    private void setImageViews() {
        setGlide();
        setPicasso();
        setFresco();
    }

    private void setGlide() {
        MediaManager.get().setDownloadRequestBuilderFactory(new GlideDownloadRequestBuilderFactory());
        ImageView imageView = binding.imageWidgetGlideImageview;
        MediaManager.get().download(requireActivity()).load(MediaManager.get().url().generate("Demo%20app%20content/Frame_871_ao5o4r")).into(imageView);
    }

    private void setPicasso() {
        MediaManager.get().setDownloadRequestBuilderFactory(new PicassoDownloadRequestBuilderFactory());
        ImageView imageView = binding.imageWidgetPicassoImageview;
        MediaManager.get().download(requireActivity()).load(MediaManager.get().url().generate("Demo%20app%20content/Frame_871_ao5o4r")).into(imageView);
    }

    private void setFresco() {
        MediaManager.get().setDownloadRequestBuilderFactory(new FrescoDownloadRequestBuilderFactory());
        SimpleDraweeView imageView = binding.imageWidgetFrescoImageview;
        MediaManager.get().download(requireActivity()).load(MediaManager.get().url().generate("Demo%20app%20content/Frame_871_ao5o4r")).into(imageView);
    }
}
