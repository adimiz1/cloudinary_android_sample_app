package com.cloudinary.cloudinarysampleapp.main.delivery.transform.inner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.R;
import com.cloudinary.cloudinarysampleapp.databinding.DeliveryTransformCellBinding;
import com.cloudinary.cloudinarysampleapp.databinding.TransformationCellBinding;
import com.cloudinary.cloudinarysampleapp.main.delivery.transform.DeliveryTransformAdapter;
import com.cloudinary.cloudinarysampleapp.main.delivery.transform.OnTransformationItemSelectedListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransformationAdapter extends RecyclerView.Adapter<TransformationAdapter.TransformationCellViewHolder> {

private List<String> dataList;

private TransformationCellBinding binding;


    OnTransformationItemSelectedListener onTransformationItemSelectedListener;

    public TransformationAdapter(Context context, OnTransformationItemSelectedListener listener) {
        dataList = new ArrayList<>(Collections.nCopies(4, ""));
        onTransformationItemSelectedListener = listener;
    }

    @NonNull
    @Override
    public TransformationCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.binding = TransformationCellBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.custom_cell_layout, parent, false);
        return new TransformationCellViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TransformationCellViewHolder holder, int position) {
        holder.setImageView(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelected(holder.getBindingAdapterPosition());
            }
        });
        // Bind other data to your custom cell views here if needed
    }

    private void itemSelected(int position) {
        onTransformationItemSelectedListener.onTransformationItemSelected(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

public static class TransformationCellViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    public TransformationCellViewHolder(@NonNull TransformationCellBinding binding) {
        super(binding.getRoot());
        imageView = binding.transformationCellImageview;
    }

    public void setImageView(int position) {
        switch (position) {
            case 0:
                Glide.with(imageView).load(MediaManager.get().url().transformation(new Transformation().crop("thumb")).generate("Demo%20app%20content/content-aware-crop-4-ski_louxkt")).into(imageView);
                break;
            case 1:
                Glide.with(imageView).load(MediaManager.get().url().transformation(new Transformation().crop("thumb")).generate("Demo%20app%20content/layers-fashion-2_1_xsfbvm")).into(imageView);
                break;
            case 2:
                Glide.with(imageView).load(MediaManager.get().url().transformation(new Transformation().crop("thumb")).generate("Demo%20app%20content/bgr-furniture-1_isnptj")).into(imageView);
                break;
            case 3:
                Glide.with(imageView).load(MediaManager.get().url().transformation(new Transformation().crop("thumb")).generate("Demo%20app%20content/recolor-tshirt-5_omapls")).into(imageView);
                break;
        }
    }
}
}