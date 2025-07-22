package com.flipfit.beans;

public class Notifications extends Customer, GymOwner{
    public String getNotificationsID() {
        return NotificationsID;
    }

    public void setNotificationsID(String notificationsID) {
        NotificationsID = notificationsID;
    }

    public String getReciversEmail() {
        return reciversEmail;
    }

    public void setReciversEmail(String reciversEmail) {
        this.reciversEmail = reciversEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    private String NotificationsID;
    private String reciversEmail;
    private String message;
    private Timestamp time;
    private String notificationType;

}

