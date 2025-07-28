package com.flipkart.business;
/*
 * @Author : "Yashvardhan Yadav, Abdul Razique, Kallakuri trilekya sri"
 * @ClassName: "GymNotificationService"
 * @Description: "Business Service layer for managing notifications within the FlipFit application.
 * This class handles the creation and sending of various types of notifications,
 * such as payment confirmations and admin approvals, keeping track of the last notification sent."
 * @Exceptions: "No specific custom exceptions defined yet, but could include NotificationException"
 * @Version : "1.0"
 * @See : "com.flipkart.beans.GymCentre, com.flipkart.beans.GymCustomer" // Assuming these might be relevant to notifications
 *
 *
 */
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