package com.example.pianoafrik.whatsaapclone.fakemodel;

/**
 * Created by pianoafrik on 3/23/17.
 */

public class Status {

    private int    profilePicture;
    private String nameOfSender;
    private String message;
    private int    messageCount;

    public Status(int profilePicture, String nameOfSender, String message) {
        this.profilePicture = profilePicture;
        this.nameOfSender = nameOfSender;
        this.message = message;

    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getNameOfSender() {
        return nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender = nameOfSender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
