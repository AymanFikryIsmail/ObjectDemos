package com.example.socialdemo.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.socialdemo.R;
import com.example.socialdemo.data.model.MyMessage;

import java.util.List;


/**
 * Created by ayman on 2019-03-26.
 */

public class ChildMessagesAdapter extends  RecyclerView.Adapter<ChildMessagesAdapter.ViewHolder> {


    private List<MyMessage> mMessages;

    private Context context;

    public ChildMessagesAdapter(Context context, List<MyMessage> messages) {
        this.mMessages = messages;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_message_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        MyMessage message = mMessages.get(position);
        viewHolder.bind(message);

    }


    @Override
    public int getItemCount() {
        return mMessages.size();
    }


    @Override
    public int getItemViewType(int position) {
        return 0;//mMessages.get(position).getType();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mMessageView;//, sendername;
        ImageView sendermsgImage, receivermsgImage;
        public LinearLayout msglayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mMessageView = (TextView) itemView.findViewById(R.id.cellTvCustomMessagesGridId);
            sendermsgImage = (ImageView) itemView.findViewById(R.id.sendermsgImageId);
            receivermsgImage = (ImageView) itemView.findViewById(R.id.receivermsgImageId);
            msglayout = itemView.findViewById(R.id.msglayoutid);


        }

        public void bind(final MyMessage message) {
            int position = getAdapterPosition();
            mMessageView.setText(message.getBody());
//            sendername.setText(message.getSender_name());

            if (message.getSender_id() == 1) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.START;
                msglayout.setLayoutParams(params);
                mMessageView.setLayoutParams(params);
                mMessageView.setTextColor(context.getResources().getColor(R.color.white));
//                mMessageView.setBackgroundResource(R.drawable.message_recevier_drawable);
                receivermsgImage.setVisibility(View.GONE);
            } else {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.END;
                msglayout.setLayoutParams(params);
                mMessageView.setLayoutParams(params);
                mMessageView.setTextColor(context.getResources().getColor(R.color.black));
//                mMessageView.setBackgroundResource(R.drawable.message_drawable);
                sendermsgImage.setVisibility(View.GONE);
            }
        }

    }

    public void updateList(List<MyMessage> newlist) {
        mMessages=newlist;
        this.notifyDataSetChanged();
    }
}
