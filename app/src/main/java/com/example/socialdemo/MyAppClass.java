package com.example.socialdemo;


import android.app.Application;

import com.example.socialdemo.api.APIURLs;
import com.example.socialdemo.api.ApiEndPointInterface;
import com.example.socialdemo.utility.Fonts;
import com.example.socialdemo.utility.notification.ExampleNotificationOpenedHandler;
import com.example.socialdemo.utility.notification.ExampleNotificationReceivedHandler;
import com.onesignal.OneSignal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyAppClass extends Application {

    private static MyAppClass instance;
    private ApiEndPointInterface apiEndPointInterface, googleApiEndPointInterface, googlePlacesApiEndPointInterface;
    private Fonts fonts;
    private static boolean activityVisible;

    public MyAppClass() {
        instance = this;
    }
    public static MyAppClass getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.startInit(this)
                .setNotificationReceivedHandler(new ExampleNotificationReceivedHandler(getApplicationContext()))
                .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
               // .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }


    public ApiEndPointInterface getApi(){
        if (apiEndPointInterface == null){
            setupApiEndPoint();
        }
        return apiEndPointInterface;
    }

    private void setupApiEndPoint(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(APIURLs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        apiEndPointInterface = builder.build().create(ApiEndPointInterface.class);
    }

}
