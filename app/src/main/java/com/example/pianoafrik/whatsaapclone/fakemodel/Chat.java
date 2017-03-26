package com.example.pianoafrik.whatsaapclone.fakemodel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pianoafrik on 3/23/17.
 */

public class Chat implements Serializable {

    private int    pix;
    private String nameOfSender;
    private String message;
    private String messageSent;

    public Chat(int profilePicture, String nameOfSender, String messge, String messageSent) {
        this.pix = profilePicture;
        this.nameOfSender = nameOfSender;
        this.message = messge;
        this.messageSent = messageSent;
    }

    public int getProfilePicture() {
        return pix;
    }

    public void setProfilePicture(int profilePicture) {
        this.pix = profilePicture;
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
