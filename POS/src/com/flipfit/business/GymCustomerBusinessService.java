package com.flipfit.business;
import com.flipfit.beans.GymCustomer;

import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.dao.GymOwnerDAO;

import java.util.Scanner;

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
        GymOwnerDAO.getAllGyms();
    }
    public  void bookSlot(String userName){
        viewAllGyms();
        GymCustomerDAO.bookSlot(userName);
    }
    public  void cancelSlot(String userName){
        GymCustomerDAO.cancelBooking(userName);
        System.out.println("Slot Canceled");
    }
}
