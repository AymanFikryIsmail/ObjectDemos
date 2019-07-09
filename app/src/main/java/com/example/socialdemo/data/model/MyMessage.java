package com.example.socialdemo.data.model;

import java.io.Serializable;

/**
 * Created by ayman on 2019-02-02.
 */

public class MyMessage implements Serializable {

    private int id;
    private String body;
    private int sender_id;
    private int reciever_id;
    private int parent_msg_id;
    private String sender_name;
    private String reciever_name;
    private String sender_photo;
    private String reciever_photo;

    public MyMessage() {
    }

    public MyMessage(int sender_id) {
        this.sender_id = sender_id;
    }

    public MyMessage(int id, String body, int sender_id, int reciever_id,
                     int parent_msg_id, String sender_name, String reciever_name,
                     String sender_photo, String reciever_photo) {
        this.id = id;
        this.body = body;
        this.sender_id = sender_id;
        this.reciever_id = reciever_id;
        this.parent_msg_id = parent_msg_id;
        this.sender_name = sender_name;
        this.reciever_name = reciever_name;
        this.sender_photo = sender_photo;
        this.reciever_photo = reciever_photo;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public int getSender_id() {
        return sender_id;
    }

    public int getReciever_id() {
        return reciever_id;
    }

    public int getParent_msg_id() {
        return parent_msg_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public String getReciever_name() {
        return reciever_name;
    }

    public String getSender_photo() {
        return sender_photo;
    }

    public String getReciever_photo() {
        return reciever_photo;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public void setReciever_id(int reciever_id) {
        this.reciever_id = reciever_id;
    }


    public void setParent_msg_id(int parent_msg_id) {
        this.parent_msg_id = parent_msg_id;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public void setReciever_name(String reciever_name) {
        this.reciever_name = reciever_name;
    }

    public void setSender_photo(String sender_photo) {
        this.sender_photo = sender_photo;
    }

    public void setReciever_photo(String reciever_photo) {
        this.reciever_photo = reciever_photo;
    }
}
