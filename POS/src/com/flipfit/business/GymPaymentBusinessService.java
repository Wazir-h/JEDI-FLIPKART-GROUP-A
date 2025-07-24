package com.flipfit.business;

public class GymPaymentBusinessService {
    public static void makePayment(String customerId, double amount, int slotStartTime, int slotEndTime) {
        System.out.println("\n--- Initiating Payment Process ---");
        System.out.println("Customer: " + customerId + ", Amount: Rs." + amount);

        boolean isPaymentSuccessful = true;

        if (isPaymentSuccessful) {
            System.out.println("Paymenet Succesful");
        }
        else {
            System.out.println("Paymenet Not Succesful");
        }
    }
    public void retrievePaymentInfo(){

    }
}
