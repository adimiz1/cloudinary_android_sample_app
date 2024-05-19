package com.cloudinary.cloudinarysampleapp.main.delivery.transform.inner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.cloudinarysampleapp.databinding.TransformationFragmentBinding;
import com.cloudinary.cloudinarysampleapp.main.delivery.background.BackgroundNormalizingFragment;
import com.cloudinary.cloudinarysampleapp.main.delivery.color.ColorAlternationFragment;
import com.cloudinary.cloudinarysampleapp.main.delivery.localization.LocalizationFragment;
import com.cloudinary.cloudinarysampleapp.main.delivery.transform.OnTransformationItemSelectedListener;

public class TransformationFragment extends Fragment implements OnTransformationItemSelectedListener {

    TransformationFragmentBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = TransformationFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setFragment(TransformationType.SmartCropping);
        setRecycleView();
    }

    private void setRecycleView() {
        RecyclerView recyclerView = binding.transformationInnerRecyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        TransformationAdapter adapter = new TransformationAdapter(getActivity(), this);
        recyclerView.setAdapter(adapter);
    }

    private void setFragment(TransformationType type) {
        Fragment fragment = null;
        switch (type) {
            case SmartCropping:
                fragment = new SmartCroppingFragment();
                break;
            case LocalizationAndBranding:
                fragment = new LocalizationFragment();
                break;
            case BackgroundNormalizing:
                fragment = new BackgroundNormalizingFragment();
                break;
            case ColorAlternation:
                fragment = new ColorAlternationFragment();
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(binding.transformationFragmentContainer.getId(), fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onTransformationItemSelected(int position) {
        switch(position) {
            case 0:
                setFragment(TransformationType.SmartCropping);
                break;
            case 1:
                setFragment(TransformationType.LocalizationAndBranding);
                break;
            case 2:
                setFragment(TransformationType.BackgroundNormalizing);
                break;
            case 3:
                setFragment(TransformationType.ColorAlternation);
                break;
            default:
                setFragment(TransformationType.SmartCropping);
                break;

        }
    }
}

