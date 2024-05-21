package com.cloudinary.cloudinarysampleapp.main.delivery.usecases.inner.adapt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.media3.common.Player;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.cldvideoplayer.CldVideoPlayer;
import com.cloudinary.cloudinarysampleapp.databinding.AdaptToScreenSizeBinding;
import com.cloudinary.cloudinarysampleapp.databinding.ConditionalProductBadgingBinding;

public class AdaptToScreenSizeFragment extends Fragment {
    AdaptToScreenSizeBinding binding;

    String publicId = "DevApp_Adapt_Video_02_diett8";

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = AdaptToScreenSizeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setVideoPlayer();
    }

    private void setVideoPlayer() {
        CldVideoPlayer player = new CldVideoPlayer(this.getContext(), MediaManager.get().url().resourceType("video").generate(publicId));
        player.getPlayer().setRepeatMode(Player.REPEAT_MODE_ALL);
        binding.playerView.setPlayer(player.getPlayer());
        player.play();
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
}
