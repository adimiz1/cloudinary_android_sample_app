package com.cloudinary.cloudinarysampleapp.main.delivery.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cloudinary.cloudinarysampleapp.R;
import com.cloudinary.cloudinarysampleapp.databinding.ActivityBaseBinding;
import com.cloudinary.cloudinarysampleapp.databinding.ActivityMainBinding;
import com.cloudinary.cloudinarysampleapp.databinding.HeadingBinding;
import com.cloudinary.cloudinarysampleapp.helpers.StringHelper;
import com.cloudinary.cloudinarysampleapp.main.delivery.optimization.OptimizationFragment;
import com.cloudinary.cloudinarysampleapp.main.delivery.transform.inner.TransformationFragment;

public class BaseActivity extends AppCompatActivity {

    public static final String EXTRA_ACTIVITY_TYPE = "activity_type";
    ActivityBaseBinding binding;
    HeadingBinding headingBinding;

    BaseActivityType type = BaseActivityType.Optimization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int typeOrdinal = getIntent().getIntExtra(EXTRA_ACTIVITY_TYPE, BaseActivityType.Optimization.ordinal());
        type = BaseActivityType.values()[typeOrdinal];

        binding = ActivityBaseBinding.inflate(getLayoutInflater());
        headingBinding = binding.baseHeading;
        setContentView(binding.getRoot());
        setHeadingTitle();
        setFragmentView();
    }

    private void setFragmentView() {
        switch(type) {
            case Optimization:
                setFragment(new OptimizationFragment());
                break;
            case Transformation:
                setFragment(new TransformationFragment());
                break;
        }
    }

    private void setHeadingTitle() {
        TextView headingTitle = headingBinding.headerTitle;
        switch (type) {
            case Optimization:
                headingTitle.setText(StringHelper.captialLetter(getString(R.string.optimization)));
                break;
            case Transformation:
                headingTitle.setText(StringHelper.captialLetter(getString(R.string.transformation)));
                break;
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.baseFragemntContainer.getId(), fragment);
        fragmentTransaction.commit();
    }
}

