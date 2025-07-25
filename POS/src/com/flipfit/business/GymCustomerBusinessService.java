package com.flipfit.business;
import com.flipfit.beans.GymCustomer;

import com.flipfit.constant.SqlQueries;
import com.flipfit.dao.DBConnection;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.dao.GymOwnerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.List;

public class GymCustomerBusinessService implements GymCustomerBusinessServiceInterface{

    public static GymCustomer createProfile(String userName,String EmailId,String userPhoneNo,String userAddress,String userPassword){
        //Complete This -----------------------------------------
//        System.out.println("Profile Created");
        GymCustomer gymCustomer = new GymCustomer();
        gymCustomer.setUserName(userName);
        gymCustomer.setUserEmail(EmailId);
        gymCustomer.setPhoneNo(userPhoneNo);
        gymCustomer.setAddress(userAddress);
        gymCustomer.setUserPassword(userPassword);
        GymCustomerDAO.addCustomer(userName,gymCustomer);
        return gymCustomer;
    }
    public void updateProfile(GymCustomer gymCustomer) {
        Scanner sc = new Scanner(System.in);
        String userNameOld = gymCustomer.getUserName();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(SqlQueries.GET_USER_BY_USERNAME);
            ps.setString(1, userNameOld);
            rs = ps.executeQuery();

            if (rs.next()) {
                String userId = rs.getString("user_id");
                String userName = rs.getString("user_name");
                String userEmail = rs.getString("user_email");
                String userPassword = rs.getString("user_password");
                String userRole = rs.getString("role_id");
                String userAddress = rs.getString("address");
                String userPhoneNo = rs.getString("phone_no");

                gymCustomer.setUserId(userId);
                gymCustomer.setUserName(userName);
                gymCustomer.setUserEmail(userEmail);
                gymCustomer.setUserPassword(userPassword);
                gymCustomer.setRoleid(userRole);
                gymCustomer.setAddress(userAddress);
                gymCustomer.setPhoneNo(userPhoneNo);


            }

        } catch (SQLException e) {
            System.err.println("SQL Error during customer registration: " + e.getMessage());
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // Ensure rollback on error
            } catch (SQLException rbEx) {
                System.err.println("Error during rollback: " + rbEx.getMessage());
            }

        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true); // Reset auto-commit
            } catch (SQLException e) {
                System.err.println("Error resetting auto-commit: " + e.getMessage());
            }

        }
        System.out.println("Enter What to Update");
        System.out.println("1. To Update Your Name");
        System.out.println("2. To Update Your EmailId");
        System.out.println("3. To Update Your PassWord");
        System.out.println("4. To Update Your Phone Number");
        System.out.println("5. To Update Your Address");
        try {
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter Your New Name");
                String newUserName = sc.nextLine();
                gymCustomer.setUserName(newUserName);
            } else if (choice == 2) {
                System.out.println("Enter Your New EmailId");
                String newUserEmailId = sc.nextLine();
                gymCustomer.setUserEmail(newUserEmailId);
            } else if (choice == 3) {
                System.out.println("Enter Your New PassWord");
                String newUserPassWord = sc.nextLine();
                gymCustomer.setUserPassword(newUserPassWord);
            } else if (choice == 4) {
                System.out.println("Enter Your New Phone Number");
                String newUserPhoneNumber = sc.nextLine();
                gymCustomer.setPhoneNo(newUserPhoneNumber);

            } else if (choice == 5) {
                System.out.println("Enter Your New Address");
                String newUserAddress = sc.nextLine();
                gymCustomer.setAddress(newUserAddress);
            } else {
                // Handle invalid number choices
                System.out.println("Invalid choice. No changes were made.");
            }
        } catch (Exception e) {
            // Catches non-integer input for 'choice'
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
        }

            GymCustomerDAO.updateCustomerProfile(userNameOld, gymCustomer);
            System.out.println("Profile updated successfully!");

    }
    public String getRole(){
        System.out.println("Role:");
        return "";
    }
    public void viewAllBookings(String userName){
        GymCustomerDAO.viewBookings(userName);
    }
    public void viewAllGyms(){
        GymOwnerDAO.viewApprovedGyms(null);
    }
    public  void bookSlot(String userName){
        viewAllGyms();
        GymCustomerDAO.bookSlot(userName);
    }
    public void viewAllAvailableSlots(String userName){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Gym Name to view slots: ");
        String gymId = sc.nextLine();
        List<Integer> slotsForGym = GymCustomerDAO.GymBookings.get(gymId);
        System.out.println("Available Slots Details:");
        System.out.println("Morning 6-7: " + slotsForGym.get(0));
        System.out.println("Morning 7-8: " + slotsForGym.get(1));
        System.out.println("Morning 8-9: " + slotsForGym.get(2));
        System.out.println("Evening 6-7: " + slotsForGym.get(3));
        System.out.println("Evening 7-8: " + slotsForGym.get(4));
        System.out.println("Evening 8-9: " + slotsForGym.get(5));
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
    public  void cancelSlot(String userName){
        GymCustomerDAO.cancelBooking(userName);
        System.out.println("Slot Canceled");
    }
}
