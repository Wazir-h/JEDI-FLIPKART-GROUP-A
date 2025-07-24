package com.flipkart.business;

public class GymNotificationService {
    // To keep the track of last Notification
    private String lastNotificationSent = "";

    public void sendNotification(String notificationType, String slotStartTime, String slotEndTime) {
        String notificationMessage = "Notification Sent: ";

        if ("Payment".equals(notificationType)) {
            notificationMessage = "Congratulations! Your payment is done. Your gym slot for " + slotStartTime + " to " + slotEndTime + " is booked.";
        } else if ("Admin".equals(notificationType)) {
            notificationMessage = "Admin Approval";
        }

        this.lastNotificationSent = notificationMessage;
    }

    public String getNotification() {
        return this.lastNotificationSent;
    }

    public void createNotification() {
        System.out.println("Notification Created");
    }
}