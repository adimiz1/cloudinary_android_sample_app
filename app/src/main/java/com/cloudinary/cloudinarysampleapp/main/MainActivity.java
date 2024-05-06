package com.cloudinary.cloudinarysampleapp.main;

import android.os.Bundle;

import com.cloudinary.cloudinarysampleapp.R;
import com.cloudinary.cloudinarysampleapp.main.delivery.DeliveryFragment;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.cloudinarysampleapp.databinding.ActivityMainBinding;
import com.cloudinary.cloudinarysampleapp.main.delivery.optimization.OptimizationFragment;

import android.view.Window;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DeliveryFragment deliveryFragment = new DeliveryFragment();
        setFragment(deliveryFragment);
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}