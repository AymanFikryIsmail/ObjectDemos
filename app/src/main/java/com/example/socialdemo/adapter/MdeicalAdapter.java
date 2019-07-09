package com.example.socialdemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialdemo.R;
import com.example.socialdemo.data.model.MedicalPojo;

import java.util.List;

public class MdeicalAdapter extends RecyclerView.Adapter<MdeicalAdapter.MedicalViewHolder> {

    private List<MedicalPojo> medicalPojos ;
    private Context mcontext;

    public MdeicalAdapter(List<MedicalPojo> medicalPojos, Context context) {
        this.medicalPojos = medicalPojos;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public MedicalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medical_row, parent, false);
//        itemView.getLayoutParams().width = (int) (getScreenWidth() / 3.5);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mcontext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.width = (int) (width / 3.8);
        itemView.setLayoutParams(layoutParams);
        return new MedicalViewHolder(itemView);
    }

    public int getScreenWidth() {
        WindowManager wm = (WindowManager) mcontext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    @Override
    public void onBindViewHolder(@NonNull MedicalViewHolder holder, int position) {
        holder.bind(medicalPojos.get(position));

    }

    @Override
    public int getItemCount() {
        return medicalPojos.size();
    }

    public class MedicalViewHolder extends RecyclerView.ViewHolder {
        public TextView medicineName;
        public ImageView medicineImage;

        public MedicalViewHolder(@NonNull View itemView) {
            super(itemView);

//            medicineName = itemView.findViewById(R.id.details);
//            medicineImage = itemView.findViewById(R.id.ratingBar);

        }

        public void bind(final MedicalPojo medicalPojo) {

        }
    }


}
