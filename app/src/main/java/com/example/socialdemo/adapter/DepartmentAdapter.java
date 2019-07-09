package com.example.socialdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialdemo.R;
import com.example.socialdemo.data.model.MedicalPojo;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.MedicalViewHolder> {

    private List<MedicalPojo> medicalPojos ;

    private Context mcontext;
    public DepartmentAdapter(List<MedicalPojo> medicalPojos, Context context) {
        this.medicalPojos = medicalPojos;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public MedicalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.department_grid_row, parent, false);
        return new MedicalViewHolder(itemView);
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
