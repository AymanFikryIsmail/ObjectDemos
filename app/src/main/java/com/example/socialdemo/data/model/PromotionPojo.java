package com.example.socialdemo.data.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PromotionPojo {

  private   String name;
    private   String image;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions().circleCrop())

                .into(view);
    }



//    @BindingAdapter(value={"imageUrl", "placeholder"}, requireAll=false)
//    public static void loadImage(ImageView view, String imageUrl,
//                                 Drawable placeHolder) {
//        if (imageUrl == null) {
//            view.setImageDrawable(placeHolder);
//        } else {
//
//            Glide.with(view.getContext())
//                    .load(imageUrl).apply(new RequestOptions().circleCrop())
//
//                    .into(view);
//        }
//    }
}
