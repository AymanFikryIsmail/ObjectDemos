package com.example.socialdemo.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;

import com.example.socialdemo.R;

import java.util.Locale;

public class Fonts {
    Typeface latoRegularTypeFace, poppinsSemiBoldTypeFace, tajawalBoldTypeFace, tajawalRegTypeFace;
    private static Fonts instance;

    private Fonts(Context mcontext) {
        latoRegularTypeFace = ResourcesCompat.getFont(mcontext, R.font.lato_regular);
        poppinsSemiBoldTypeFace = ResourcesCompat.getFont(mcontext, R.font.poppins_semibold);
        tajawalBoldTypeFace = ResourcesCompat.getFont(mcontext, R.font.tajawal_bold);
        tajawalRegTypeFace = ResourcesCompat.getFont(mcontext, R.font.tajawal_reg);
    }

    public static synchronized Fonts getInstance(Context mcontext) {
        if (instance == null) {
            if (instance == null) {
                instance = new Fonts(mcontext);
            }
        }
        return instance;
    }

    public Typeface getCustomFont() {
        String languagetype = Locale.getDefault().getLanguage();//"en";//sharedPreferences_show.getString("languagetype","ar");
        if (languagetype.equals("en")) {
            return latoRegularTypeFace;
        } else {
            return poppinsSemiBoldTypeFace;
        }
    }

    public Typeface getTajawalFont() {
        String languagetype = Locale.getDefault().getLanguage();//"en";//sharedPreferences_show.getString("languagetype","ar");
        if (languagetype.equals("en")) {
            return tajawalBoldTypeFace;
        } else {
            return tajawalRegTypeFace;
        }
    }


}
