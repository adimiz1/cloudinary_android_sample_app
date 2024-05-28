package com.cloudinary.cloudinarysampleapp.main.upload;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cloudinary.cloudinarysampleapp.databinding.ActivityBaseBinding;
import com.cloudinary.cloudinarysampleapp.databinding.NoCloudFragmentBinding;

public class NoCloudActivity extends AppCompatActivity {

    NoCloudFragmentBinding binding;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = NoCloudFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setCloseButton();
        setGetStartedButton();
        setCantFindCloudName();
    }

    private void setCantFindCloudName() {
        binding.cantFindCloudContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WebViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setGetStartedButton() {
        binding.getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCloudName(binding.hiDevelopersEdittext.getText().toString());
                finish();
            }
        });
    }

    private void saveCloudName(String cloudName) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cloud_name", cloudName);
        editor.apply();
    }

    private void setCloseButton() {
        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
