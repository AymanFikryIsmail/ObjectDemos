package com.example.socialdemo.data.repositories;

import com.example.socialdemo.data.model.PromotionPojo;
import com.example.socialdemo.listeners.OnResponseListener;

import java.util.List;

public interface PromotionRepository {
    void getPromotionList( OnResponseListener<List<PromotionPojo>> onGetPrayerTimesResponse);

}
