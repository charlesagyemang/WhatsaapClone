package com.example.pianoafrik.whatsaapclone.fakemodel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pianoafrik on 3/23/17.
 */

public class Chat implements Serializable {

    private int    profilePicture;
    private String nameOfSender;
    private String message;
    private String messageSent;
    private int    messagesCount;


    public Chat(int profilePicture, String nameOfSender, String message, String messageSent, int messagesCount) {
        this.profilePicture = profilePicture;
        this.nameOfSender = nameOfSender;
        this.message = message;
        this.messageSent = messageSent;
        this.messagesCount = messagesCount;
    }

    public String getNameOfSender() {
        return nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender = nameOfSender;
    }

    public String getMessge() {
        return message;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    public void setMessge(String messge) {
        this.message = messge;
    }

    public String getMessageSent() {
        return messageSent;
    }

    public void setMessageSent(String messageSent) {
        this.messageSent = messageSent;
    }
}
