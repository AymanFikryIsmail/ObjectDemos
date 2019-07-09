package com.example.socialdemo.utility.fireBaseHelper;

import android.util.Log;

import com.example.socialdemo.data.model.MyMessage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ayman on 2019-03-26.
 */

public class FireBaseHelper {

    FirebaseDatabase database;
    public FireBaseHelper() {
        database = FirebaseDatabase.getInstance();
    }
    public void createMessageOnFirebase(MyMessage myMessage) {
        int first=myMessage.getSender_id();
        int second =myMessage.getReciever_id() ;
        String chatRoom;
        if (first<second){
            chatRoom=first+"and"+second;
        }else {
            chatRoom=second+"and"+first;
        }
        DatabaseReference myRef = database.getReference(chatRoom );
        myRef.child(String.valueOf(new Date().getTime())).setValue(myMessage);

        DatabaseReference mySenderRef = database.getReference(first+"" );
        mySenderRef.child(""+second).setValue(myMessage);

        DatabaseReference myReceiverRef = database.getReference(second+"" );
        myReceiverRef.child(""+first).setValue(myMessage);
    }

    public void retrieveUserMessageFromFirebase(MyMessage myMessage , final FireBaseCallBack fireBaseCallBack) {
        int first=myMessage.getSender_id();
        int second =myMessage.getReciever_id() ;
        String chatRoom;
        if (first<second){
            chatRoom=first+"and"+second;
        }else {
            chatRoom=second+"and"+first;
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(chatRoom);

        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ArrayList<MyMessage> messages;
                        messages = new ArrayList<>();
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            //userSna//pshot.child()
                            MyMessage message = userSnapshot.getValue(MyMessage.class);
                            messages.add(message);
                        }
                        fireBaseCallBack.getMessages(messages);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("chat","aaa");
                    }
                });
    }




    public void retrieveParentMessageFromFirebase(MyMessage myMessage , final FireBaseCallBack fireBaseCallBack) {

        int first=myMessage.getSender_id();
        String chatRoom="";

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(first+"");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final ArrayList<MyMessage> messages;
                        messages = new ArrayList<>();
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            //userSnapshot.child()
                            MyMessage message = userSnapshot.getValue(MyMessage.class);
                            messages.add(message);
                        }
                        fireBaseCallBack.getMessages(messages);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
    }
}

