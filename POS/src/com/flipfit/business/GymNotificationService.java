package com.flipkart.business;

import com.flipfit.business.GymNotificationServiceInterface;

public class GymNotificationService implements GymNotificationServiceInterface {
    public void sendNotification() {
        System.out.println("Notification Sent");
    }

    public String getNotification() {
        String currentNotification = "";
        return currentNotification;
    }

    public void createNotification() {
        System.out.println("Notification Created");
    }
}