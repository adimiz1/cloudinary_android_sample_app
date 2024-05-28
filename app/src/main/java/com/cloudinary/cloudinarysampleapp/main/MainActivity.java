package com.cloudinary.cloudinarysampleapp.main;

import android.os.Bundle;

import com.cloudinary.cloudinarysampleapp.R;
import com.cloudinary.cloudinarysampleapp.main.delivery.DeliveryFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.cloudinarysampleapp.databinding.ActivityMainBinding;
import com.cloudinary.cloudinarysampleapp.main.delivery.optimization.OptimizationFragment;
import com.cloudinary.cloudinarysampleapp.main.video.VideoFragment;
import com.cloudinary.cloudinarysampleapp.main.widgets.WidgetsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.view.MenuItem;
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
        setBottomNavigationView();
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private void setBottomNavigationView() {
        BottomNavigationView bottomNavigationView = binding.contentMain.navigationView;
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.navigation_delivery) {
                    setFragment(new DeliveryFragment());
                    return true;
                } else if(id == R.id.navigation_upload) {

                } else if(id == R.id.navigation_widgets) {
                    setFragment(new WidgetsFragment());
                    return true;

                } else if(id == R.id.navigation_video) {
                    setFragment(new VideoFragment());
                    return true;
                }
                return false;
            }
        });
    }
}