package com.example.socialdemo.ui.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.socialdemo.R;
import com.example.socialdemo.adapter.ChildMessagesAdapter;
import com.example.socialdemo.data.model.MyMessage;
import com.example.socialdemo.utility.fireBaseHelper.FireBaseCallBack;
import com.example.socialdemo.utility.fireBaseHelper.FireBaseHelper;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private List<MyMessage> mMessages = new ArrayList<>();
    private EditText messagetxt;
    RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView messagesGridView;
    private ChildMessagesAdapter messagesAdapter;
    ImageButton sendButton;
    private MyMessage associationMessage;
    private FireBaseHelper fireBaseHelper;

    MyMessage myMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        fireBaseHelper=new FireBaseHelper();
        messagesGridView = (RecyclerView) findViewById(R.id.childmessagesGVMessagesId);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        messagesGridView.setLayoutManager(mLayoutManager);
        ((LinearLayoutManager) messagesGridView.getLayoutManager()).setStackFromEnd(true);
        sendButton = (ImageButton) findViewById(R.id.send_button);
        messagetxt = (EditText) findViewById(R.id.message_input);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        messagesAdapter = new ChildMessagesAdapter(this,mMessages);
        mMessages = null;
        getMessage();
    }

    private  void sendMessage(){
        MyMessage message1;
        int receiverId= 1;

            message1=new MyMessage(1, messagetxt.getText().toString(),2
                    , receiverId,1
                    ,"ahmed"
                    ,"ayman" , "","");

        fireBaseHelper.createMessageOnFirebase(message1);
        messagetxt.setText("");
        getMessage();
    }
    private void getMessage() {
        MyMessage message1;
        int receiverId=1;

            message1=new MyMessage(1, messagetxt.getText().toString(),2
                    ,receiverId ,1
                    ,"ayman"
                    , "ahmed" ,"" ,"" );

        fireBaseHelper.retrieveUserMessageFromFirebase(message1, new FireBaseCallBack() {
            @Override
            public void getMessages(ArrayList<MyMessage> messages) {
                messagesAdapter.updateList(messages);
                messagesGridView.setAdapter(messagesAdapter);
            }
        });
    }
}
