package com.example.socialdemo.utility;

import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;

import com.example.socialdemo.R;

import java.util.Locale;

public class FontAdapter {
    @BindingAdapter("android:typeface")
    public static void setTypeface(TextView v, String style) {
        switch (style) {
            case "generalFont":
                    v.setTypeface(Fonts.getInstance(v.getContext()).getTajawalFont());
                break;
            default:
                v.setTypeface(Fonts.getInstance(v.getContext()).getCustomFont());
                break;
        }
    }
}
