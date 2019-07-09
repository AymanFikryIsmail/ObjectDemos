package com.example.socialdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialdemo.BR;
import com.example.socialdemo.R;
import com.example.socialdemo.data.model.PromotionPojo;
import com.example.socialdemo.databinding.PostjobRowBinding;
import com.example.socialdemo.viewholders.PromotionViewHolder;

import java.util.List;

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionViewHolder> {

    private List<PromotionPojo> promotionPojos ;

    private Context mcontext;
    public PromotionsAdapter(List<PromotionPojo> promotionPojos, Context context) {
        this.promotionPojos = promotionPojos;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.postjob_row, parent, false);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       PostjobRowBinding binding = DataBindingUtil.inflate(
               layoutInflater,
                R.layout.postjob_row, parent, false);

        return new PromotionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder holder, int position) {
        holder.bind(promotionPojos.get(position));
    }

    @Override
    public int getItemCount() {
        return promotionPojos.size();
    }
//    public class MedicalViewHolder extends RecyclerView.ViewHolder {
//        public TextView medicineName;
//        public ImageView medicineImage;
//        final PostjobRowBinding binding;
//        MedicalViewHolder(PostjobRowBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
//        public void bind(final PromotionPojo promotionPojo) {
//            promotionPojo.setImage("https://androidwave.com/wp-content/uploads/2019/01/profile_pic.jpg");
//            binding.setPromotionpojo(promotionPojo);
////            binding.executePendingBindings();
//        }
//    }
    public void updateList(List<PromotionPojo>newlist) {
        promotionPojos=newlist;
        this.notifyDataSetChanged();
    }
    public  void press(PromotionPojo promotionPojo){
        Toast.makeText(mcontext,"toast", Toast.LENGTH_LONG).show();
    }

}
