package com.example.socialdemo.api;

import com.example.socialdemo.data.model.PromotionPojo;
import com.example.socialdemo.data.response.CustomResponse;
import com.example.socialdemo.data.response.PromotionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndPointInterface {
    @POST("{locale}/"+ APIURLs.GET_PROMOS)
    Call<CustomResponse<List<PromotionPojo>>> getPromotionList(@Path("locale") String local);
}
