package com.flipfit.beans;

import java.sql.Timestamp;

/*
 * @Author : "Kartik Aggarwal"
 * @ClassName: "Notifications"
 * @Version : "1.0"
 */
public class Notifications extends User {
    private String NotificationsID;
    private String receiversEmail;
    private String message;
    private Timestamp time;
    private String notificationType;

    public String getNotificationsID() {
        return NotificationsID;
    }

    public void setNotificationsID(String notificationsID) {
        this.NotificationsID = notificationsID;
    }

    public String getReceiversEmail() {
        return receiversEmail;
    }

    public void setReceiversEmail(String receiversEmail) {
        this.receiversEmail = receiversEmail;
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


}

