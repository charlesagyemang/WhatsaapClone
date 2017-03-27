package com.example.pianoafrik.whatsaapclone.fakemodel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by pianoafrik on 3/23/17.
 */

@Entity
public class Chat implements Serializable {


    @Id
    private Long id;

    @NotNull
    private int    profilePicture;

    @NotNull
    private String nameOfSender;

    @NotNull
    private String message;

    @NotNull
    private String messageSent;

    @NotNull
    private int    messagesCount;

    public int getMessagesCount() {
        return this.messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    public String getMessageSent() {
        return this.messageSent;
    }

    public void setMessageSent(String messageSent) {
        this.messageSent = messageSent;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNameOfSender() {
        return this.nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender = nameOfSender;
    }

    public int getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 751290759)
    public Chat(Long id, int profilePicture, @NotNull String nameOfSender,
            @NotNull String message, @NotNull String messageSent, int messagesCount) {
        this.id = id;
        this.profilePicture = profilePicture;
        this.nameOfSender = nameOfSender;
        this.message = message;
        this.messageSent = messageSent;
        this.messagesCount = messagesCount;
    }

    @Generated(hash = 519536279)
    public Chat() {
    }



}
