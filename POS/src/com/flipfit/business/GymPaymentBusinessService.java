package com.flipfit.business;

import com.flipfit.beans.Slot;
import com.flipfit.constant.SqlQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.sql.Date;
import static com.flipfit.dao.DBConnection.getConnection;
/*
 * @Author : "Yahsvardhan Yadav, Shivansh Sinha, Kartik Aggarwal"
 * @ClassName: "GymPaymentBusinessService"
 * @Description: "Business Service layer for managing payment operations within the FlipFit application.
 * This class handles the logic for processing payments for gym slot bookings,
 * interacting with the database to record transactions and ensuring payment success."
 * @Exceptions: "SQLException (for database errors), PaymentException (custom business exception if needed)"
 * @Version : "1.0"
 * @See : "com.flipfit.beans.GymCustomer, com.flipfit.constant.SqlQueries, com.flipfit.dao.DBConnection"
 *
 *
 */
public class GymPaymentBusinessService {
    public static void makePayment(String customerId, double amount, int slotStartTime, int slotEndTime) {
        System.out.println("\n--- Initiating Payment Process ---");
        System.out.println("Customer: " + customerId + ", Amount: Rs." + amount);

        boolean isPaymentSuccessful = true;
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.JULY, 25);
        if (isPaymentSuccessful) {
            Connection db=null;
            PreparedStatement ps1=null;

            try {
                db = getConnection();
                ps1 = db.prepareStatement(SqlQueries.MAKE_PAYMENT);
                ps1.setString(1,customerId+"23");
                ps1.setString(2,customerId);
                ps1.setDouble(3,100);
                ps1.setString(4,"Success");
                ps1.setInt(5,slotStartTime);
                ps1.setInt(6,slotEndTime);
                ps1.setDate(7, new java.sql.Date(cal.getTimeInMillis()));
                int r = ps1.executeUpdate();
                try {
                    if (r>0) {

                        System.out.println("Payment Done Successfully.");

                    } else {

                        System.out.println("Payment Failed");

                    }
                }
                catch (Exception e) {

                }

            } catch (SQLException e) {
                System.err.println("DAO Error: Failed to Make Payment" + e.getMessage());
                e.printStackTrace();
            } finally {
                if(ps1!=null){
                    try {
                        ps1.close();
                    } catch (SQLException closeEx) {
                        System.err.println("Error closing PreparedStatement ps1: " + closeEx.getMessage());
                    }
                }
            }

            System.out.println("Payment Successful");
        }
        else {
            System.out.println("Payment Not Successful");
        }
    }
    public void retrievePaymentInfo(){

    }
}
