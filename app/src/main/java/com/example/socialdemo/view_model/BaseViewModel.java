package com.example.socialdemo.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    public MutableLiveData<Integer> errorCode ;

    public BaseViewModel() {
        this.errorCode = new MutableLiveData<>();
    }
}
