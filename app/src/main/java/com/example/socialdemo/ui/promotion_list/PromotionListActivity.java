package com.example.socialdemo.ui.promotion_list;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.socialdemo.R;
import com.example.socialdemo.adapter.JobItemsAdapter;
import com.example.socialdemo.adapter.PromotionsAdapter;
import com.example.socialdemo.data.model.MedicalPojo;
import com.example.socialdemo.data.model.PromotionPojo;
import com.example.socialdemo.data.repositories.NetworkPromotionRepository;
import com.example.socialdemo.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class PromotionListActivity extends BaseActivity< PromotionListViewModel>{

    private List<PromotionPojo> promotionPojos;
    private RecyclerView recyclerView ;
    private PromotionsAdapter promotionsAdapter;
    private PromotionListViewModel promotionListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_list);
        promotionPojos=new ArrayList<>();
        initView();
        getPromotionListData();
    }
    @Override
    public PromotionListViewModel getViewModel() {
        promotionListViewModel = ViewModelProviders.of(this).get(PromotionListViewModel.class);
        promotionListViewModel.init(new NetworkPromotionRepository());
        return promotionListViewModel;
    }

    void initView(){
        recyclerView = findViewById(R.id.promotionRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        promotionsAdapter = new PromotionsAdapter(promotionPojos, this);
        recyclerView.setAdapter(promotionsAdapter);
    }
    void getPromotionListData(){
        promotionListViewModel.getPromotionList().observe(this, new Observer<List<PromotionPojo>>() {
            @Override
            public void onChanged(@Nullable List<PromotionPojo> promotionPojoList) {
                promotionPojos = promotionPojoList;
                promotionsAdapter.updateList(promotionPojoList);
            }

        });
    }
    public  void press(PromotionPojo promotionPojo){
        Toast.makeText(this,"toast", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onSuccess(Response response) {
        super.onSuccess(response);
    }

    @Override
    public void onFailure() {
        super.onFailure();
    }

    @Override
    public void onAuthError() {
        super.onAuthError();
    }

    @Override
    public void onInvalidTokenError() {
        super.onInvalidTokenError();
    }

    @Override
    public void onServerError() {
        super.onServerError();
    }

    @Override
    public void onValidationError(String errorMessage) {
        super.onValidationError(errorMessage);
    }

    @Override
    public void onSuspendedUserError(String errorMessage) {
        super.onSuspendedUserError(errorMessage);
    }
}
