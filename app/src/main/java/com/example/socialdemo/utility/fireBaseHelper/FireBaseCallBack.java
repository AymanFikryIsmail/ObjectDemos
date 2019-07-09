package com.example.socialdemo.utility.fireBaseHelper;


import com.example.socialdemo.data.model.MyMessage;

import java.util.ArrayList;

/**
 * Created by ayman on 2019-03-26.
 */

public interface FireBaseCallBack {
    void getMessages(ArrayList<MyMessage> messages);

}
