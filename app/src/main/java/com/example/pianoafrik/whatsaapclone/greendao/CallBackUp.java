package com.example.pianoafrik.whatsaapclone.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by pianoafrik on 3/26/17.
 */

@Entity
public class CallBackUp {

    @Id
    private Long id;
    @NotNull
    private String callerName;

    @NotNull
    private String callerPicture;
    
    @NotNull
    private boolean callTypeIcon;

    @NotNull
    private String date;

    @NotNull
    private int numberOfCalls;

    @NotNull
    private String timeOfCall;

    public String getTimeOfCall() {
        return this.timeOfCall;
    }

    public void setTimeOfCall(String timeOfCall) {
        this.timeOfCall = timeOfCall;
    }

    public int getNumberOfCalls() {
        return this.numberOfCalls;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getCallTypeIcon() {
        return this.callTypeIcon;
    }

    public void setCallTypeIcon(boolean callTypeIcon) {
        this.callTypeIcon = callTypeIcon;
    }

    public String getCallerPicture() {
        return this.callerPicture;
    }

    public void setCallerPicture(String callerPicture) {
        this.callerPicture = callerPicture;
    }

    public String getCallerName() {
        return this.callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 2056441738)
    public CallBackUp(Long id, @NotNull String callerName,
            @NotNull String callerPicture, boolean callTypeIcon,
            @NotNull String date, int numberOfCalls, @NotNull String timeOfCall) {
        this.id = id;
        this.callerName = callerName;
        this.callerPicture = callerPicture;
        this.callTypeIcon = callTypeIcon;
        this.date = date;
        this.numberOfCalls = numberOfCalls;
        this.timeOfCall = timeOfCall;
    }

    @Generated(hash = 1545869844)
    public CallBackUp() {
    }
}
