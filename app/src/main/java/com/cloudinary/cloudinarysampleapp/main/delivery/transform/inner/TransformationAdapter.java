package com.cloudinary.cloudinarysampleapp.main.delivery.transform.inner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.cloudinarysampleapp.R;
import com.cloudinary.cloudinarysampleapp.databinding.TransformationCellBinding;
import com.cloudinary.cloudinarysampleapp.main.delivery.transform.OnTransformationItemSelectedListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransformationAdapter extends RecyclerView.Adapter<TransformationAdapter.TransformationCellViewHolder> {

    private List<String> dataList;
    private int selectedItemPosition = 0;

    private final OnTransformationItemSelectedListener onTransformationItemSelectedListener;

    public TransformationAdapter(Context context, OnTransformationItemSelectedListener listener) {
        dataList = new ArrayList<>(Collections.nCopies(4, ""));
        onTransformationItemSelectedListener = listener;
    }

    @NonNull
    @Override
    public TransformationCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TransformationCellBinding binding = TransformationCellBinding.inflate(inflater, parent, false);
        return new TransformationCellViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TransformationCellViewHolder holder, int position) {
        holder.setImageView(position);
        holder.setTextView(position);

        holder.itemView.setSelected(position == selectedItemPosition);
        holder.borderView.setVisibility(position == selectedItemPosition ? View.VISIBLE : View.INVISIBLE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelected(holder.getBindingAdapterPosition());
            }
        });
    }

    private void itemSelected(int position) {
        if (selectedItemPosition != position) {
            notifyItemChanged(selectedItemPosition);
            selectedItemPosition = position;
            notifyItemChanged(selectedItemPosition);
        }
        onTransformationItemSelectedListener.onTransformationItemSelected(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class TransformationCellViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        View borderView;

        public TransformationCellViewHolder(@NonNull TransformationCellBinding binding) {
            super(binding.getRoot());
            imageView = binding.transformationCellImageview;
            textView = binding.transformationCellTextview;
            borderView = binding.getRoot().findViewById(R.id.border_view);
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

        public void setTextView(int position) {
            switch (position) {
                case 0:
                    textView.setText(R.string.smart_cropping);
                    break;
                case 1:
                    textView.setText(R.string.localization_and_branding);
                    break;
                case 2:
                    textView.setText(R.string.background_normalizing);
                    break;
                case 3:
                    textView.setText(R.string.color_alternation);
                    break;
            }
        }
    }

    public void setSelectedItemPosition(int position) {
        selectedItemPosition = position;
    }

}
