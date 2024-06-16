package com.cloudinary.cloudinarysampleapp.main.upload.single_upload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.R;
import com.cloudinary.cloudinarysampleapp.databinding.UploadCellBinding;
import com.cloudinary.cloudinarysampleapp.local_storage.AssetModelEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UploadRecycleAdapter extends RecyclerView.Adapter<UploadRecycleAdapter.UploadCellViewHolder> {

    private List<AssetModelEntity> assetModels = new ArrayList<>();

    public UploadRecycleAdapter(Context context) {
    }

    public void setAssetModels(List<AssetModelEntity> assetModels) {
        this.assetModels = assetModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UploadCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UploadCellBinding binding = UploadCellBinding.inflate(inflater, parent, false);
        return new UploadCellViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UploadCellViewHolder holder, int position) {
        holder.setImageView(position, assetModels.get(position).getPublicId());
    }

    @Override
    public int getItemCount() {
        return assetModels.size();
    }

    public static class UploadCellViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;


        public UploadCellViewHolder(@NonNull UploadCellBinding binding) {
            super(binding.getRoot());
            imageView = binding.uploadCellImageview;
        }

        public void setImageView(int position, String publicId) {
            Glide.with(imageView).load(MediaManager.get().url().transformation(new Transformation().crop("thumb")).generate(publicId)).placeholder(R.drawable.placeholder).into(imageView);
        }
    }
}
