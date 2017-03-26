package com.example.pianoafrik.whatsaapclone.apimodel;



public class Call {

    private String callerName;
    private String callerPicture;
    private boolean callTypeIcon;
    private String date;
    private int numberOfCalls;
    private String timeOfCall;


    public Call(String callerName, String callerPicture, boolean callTypeIcon, String date, int numberOfCalls, String timeOfCall) {
        this.callerName = callerName;
        this.callerPicture = callerPicture;
        this.callTypeIcon = callTypeIcon;
        this.date = date;
        this.numberOfCalls = numberOfCalls;
        this.timeOfCall = timeOfCall;
    }

    public String getCallerPicture() {
        return callerPicture;
    }

    public void setCallerPicture(String callerPicture) {
        this.callerPicture = callerPicture;
    }

    public boolean getCallTypeIcon() {
        return callTypeIcon;
    }

    public void setCallTypeIcon(boolean callTypeIcon) {
        this.callTypeIcon = callTypeIcon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public String getTimeOfCall() {
        return timeOfCall;
    }

    public void setTimeOfCall(String timeOfCall) {
        this.timeOfCall = timeOfCall;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }
}

