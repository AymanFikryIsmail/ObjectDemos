package com.example.socialdemo.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialdemo.data.model.PromotionPojo;
import com.example.socialdemo.databinding.PostjobRowBinding;

public class PromotionViewHolder extends RecyclerView.ViewHolder  {
    public TextView medicineName;
    public ImageView medicineImage;
    final PostjobRowBinding binding;
    public PromotionViewHolder(PostjobRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind(final PromotionPojo promotionPojo) {
        promotionPojo.setImage("https://androidwave.com/wp-content/uploads/2019/01/profile_pic.jpg");
        binding.setPromotionpojo(promotionPojo);
    }
}
