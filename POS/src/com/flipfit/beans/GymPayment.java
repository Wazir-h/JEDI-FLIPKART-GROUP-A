package com.flipfit.beans;
import java.sql.Timestamp;
public class GymPayment extends GymCustomer {
   private String paymentID;
   private Timestamp paymentTime;


    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

}
