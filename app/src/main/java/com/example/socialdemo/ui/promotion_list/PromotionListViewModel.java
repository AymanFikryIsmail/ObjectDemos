package com.example.socialdemo.ui.promotion_list;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.socialdemo.data.model.PromotionPojo;
import com.example.socialdemo.data.repositories.PromotionRepository;
import com.example.socialdemo.listeners.OnResponseListener;
import com.example.socialdemo.view_model.BaseViewModel;
import java.util.List;
import retrofit2.Response;

public class PromotionListViewModel extends BaseViewModel {

    public MutableLiveData<List<PromotionPojo>> promotionList ;
    private PromotionRepository repository;


    void init(PromotionRepository repository){
        this.repository = repository;
    }


  public  MutableLiveData<List<PromotionPojo>> getPromotionList(){
        if (promotionList==null){
            promotionList=new MutableLiveData<>();
        }
      getPromotionListData();
      return promotionList;

  }
    public void getPromotionListData(){
        repository.getPromotionList(new OnResponseListener<List<PromotionPojo>>() {
            @Override
            public void onSuccess(Response response) {
                Log.d("aa","");
            }
            @Override
            public void onCustomSuccess(List<PromotionPojo> data) {
                promotionList.setValue(data);
            }

            @Override
            public void onFailure() {
                errorCode.setValue(501);

            }

            @Override
            public void onAuthError() {
                errorCode.setValue(401);
            }

            @Override
            public void onInvalidTokenError() {
                errorCode.setValue(500);

            }

            @Override
            public void onServerError() {

            }

            @Override
            public void onValidationError(String errorMessage) {

            }

            @Override
            public void onSuspendedUserError(String errorMessage) {

            }
        });
//        call.enqueue(new Callback<ApiResponse<List<PackagesPojo>>>() {
//            @Override
//            public void onResponse(Call<ApiResponse<List<PackagesPojo>>> call, Response<ApiResponse<List<PackagesPojo>>> response) {
//                if (response.body().status == "true"&&response.body().data!=null  ) {
//                    packagesData.setValue(response.body().data);
//                }
//                else {
//                   // mainView.showError("Error in connection");
//                }
//            }
//            @Override
//            public void onFailure(Call<ApiResponse<List<PackagesPojo>>> call, Throwable t) {
//                mainView.showError("Error in connection");
//            }
//        });
    }
}
