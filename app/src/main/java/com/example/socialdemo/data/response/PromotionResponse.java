package com.example.socialdemo.data.response;

import com.example.socialdemo.data.model.PromotionPojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PromotionResponse  extends BaseResponse {

    @SerializedName("data")
    @Expose
    private ArrayList<PromotionPojo> data;

    public  ArrayList<PromotionPojo> getData() {
        return data;
    }

    public void setData( ArrayList<PromotionPojo> data) {
        this.data = data;
    }
}
