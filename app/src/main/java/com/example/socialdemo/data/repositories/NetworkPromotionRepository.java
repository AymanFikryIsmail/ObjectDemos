package com.example.socialdemo.data.repositories;

import com.example.socialdemo.MyAppClass;
import com.example.socialdemo.api.ApiEndPointInterface;
import com.example.socialdemo.data.model.PromotionPojo;
import com.example.socialdemo.data.response.CustomResponse;
import com.example.socialdemo.data.response.PromotionResponse;
import com.example.socialdemo.listeners.OnResponseListener;
import com.example.socialdemo.utility.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.net.sip.SipErrorCode.SERVER_ERROR;

public class NetworkPromotionRepository implements PromotionRepository {
    private final int SERVER_ERROR = 500;
    private final int INVALID_TOKEN_ERROR = 401;   //invalid token
    private final int VALIDATION_ERROR = 422;
    private final int UNAUTHORIZED_ERROR = 403;
    private final int ACTION_DENIED_ERROR = 409;

    private ApiEndPointInterface apiEndPointInterface = MyAppClass.getInstance().getApi();


    @Override
    public void getPromotionList( final OnResponseListener<List<PromotionPojo>> onGetCustomerOrderDetailsResponse) {
        Call<CustomResponse<List<PromotionPojo>>> call = apiEndPointInterface.getPromotionList("en_US");
        call.clone().enqueue(new Callback<CustomResponse<List<PromotionPojo>>>() {
            @Override
            public void onResponse(Call<CustomResponse<List<PromotionPojo>>> call, Response<CustomResponse<List<PromotionPojo>>> response) {
                if(response.body() != null){
                    onGetCustomerOrderDetailsResponse.onCustomSuccess(response.body().getData());
                }
                else if(response.code() == INVALID_TOKEN_ERROR){
                    onGetCustomerOrderDetailsResponse.onAuthError();
                }
                else if(response.code() == SERVER_ERROR){
                    onGetCustomerOrderDetailsResponse.onServerError();
                }
                else if (response.code() == UNAUTHORIZED_ERROR){
                    try {
                        if (response.errorBody()!= null){
                            String errorBodyString = response.errorBody().string();
                            String errorMessage = readErrorMessage(errorBodyString);
                            onGetCustomerOrderDetailsResponse.onValidationError(errorMessage);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (response.code() == ACTION_DENIED_ERROR){
                    try {
                        if (response.errorBody()!= null){
                            String errorBodyString = response.errorBody().string();
                            String errorMessage = readErrorMessage(errorBodyString);
                            onGetCustomerOrderDetailsResponse.onValidationError(errorMessage);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    onGetCustomerOrderDetailsResponse.onFailure();
                }
            }

            @Override
            public void onFailure(Call<CustomResponse<List<PromotionPojo>>> call, Throwable t) {
                onGetCustomerOrderDetailsResponse.onFailure();
            }
        });
    }

    private String readErrorMessage(String errorBody) {
        JSONObject errorBodyJson;
        JSONObject errorJsonObject;
        String errorMessage = null;
        try {
            errorBodyJson = new JSONObject(errorBody);
            errorJsonObject = errorBodyJson.getJSONObject(Constants.ERROR);
            errorMessage = errorJsonObject.getString(Constants.DEFAULT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorMessage;
    }


}
