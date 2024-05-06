package com.cloudinary.cloudinarysampleapp.main.delivery.transform.inner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cloudinary.cloudinarysampleapp.R;
import com.cloudinary.cloudinarysampleapp.databinding.SmartCroppingFragmentBinding;

public class SmartCroppingFragment extends Fragment {
    SmartCroppingFragmentBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = SmartCroppingFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setImages();
    }

    private void setImages() {
        ImageView main = binding.smartCroppingMain;
        main.setImageResource(R.drawable.ski);

    }
}
