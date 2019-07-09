package com.example.socialdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.socialdemo.R;
import com.example.socialdemo.data.repositories.NetworkPromotionRepository;
import com.example.socialdemo.ui.promotion_list.PromotionListViewModel;
import com.example.socialdemo.view_model.BaseViewModel;

import retrofit2.Response;

public abstract class BaseActivity<V extends BaseViewModel>  extends AppCompatActivity {

//    private BaseViewModel baseViewModel;
    private V mViewModel;
    public abstract V getViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;

        initViewModelObserver();
    }
    void initViewModelObserver(){
        mViewModel.errorCode.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer errorCode) {
                if (errorCode==401){
                    onAuthError();
                }else {
                    onServerError();
                }
            }
        });
    }
    public void onSuccess(Response response) {
    }

    public void onFailure() {
    }

    public void onAuthError() {

    }

    public void onInvalidTokenError() {

    }

    public void onServerError() {

    }

    public void onValidationError(String errorMessage) {

    }

    public void onSuspendedUserError(String errorMessage) {

    }
}
