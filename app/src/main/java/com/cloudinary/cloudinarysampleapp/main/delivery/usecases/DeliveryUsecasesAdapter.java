package com.cloudinary.cloudinarysampleapp.main.delivery.usecases;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.cloudinarysampleapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeliveryUsecasesAdapter extends RecyclerView.Adapter<DeliveryUsecasesAdapter.DeliveryUseCasesCellViewHolder> {

        private List<String> dataList;

        private com.cloudinary.cloudinarysampleapp.databinding.DeliveryUsecaseCellBinding binding;

        public DeliveryUsecasesAdapter(Context context) {
            dataList = new ArrayList<>(Collections.nCopies(4, ""));
        }

        @NonNull
        @Override
        public DeliveryUseCasesCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            this.binding = com.cloudinary.cloudinarysampleapp.databinding.DeliveryUsecaseCellBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.custom_cell_layout, parent, false);
            return new DeliveryUseCasesCellViewHolder(binding);
        }

    @Override
    public void onBindViewHolder(@NonNull DeliveryUseCasesCellViewHolder holder, int position) {
        holder.setTextView(position);
    }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public static class DeliveryUseCasesCellViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            public DeliveryUseCasesCellViewHolder(@NonNull com.cloudinary.cloudinarysampleapp.databinding.DeliveryUsecaseCellBinding binding) {
                super(binding.getRoot());
                textView = binding.deliveryUsecasesCellTextview;
            }

            public void setTextView(int position) {
                switch (position) {
                    case 0:
                        textView.setText(R.string.auto_cropping);
                        break;
                    case 1:
                        textView.setText(R.string.overlay);
                        break;
                    case 2:
                        textView.setText(R.string.background_normalization);
                        break;
                    case 3:
                        textView.setText(R.string.generative_recolor);
                        break;
                }
            }
        }
    }

