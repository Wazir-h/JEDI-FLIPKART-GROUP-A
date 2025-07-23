package com.flipfit.business;
import com.flipfit.beans.GymCustomer;

import com.flipfit.beans.GymCustomer;

import java.util.Scanner;

public class GymCustomerBusinessService {

    public static GymCustomer createProfile(String userName,String EmailId,String userPhoneNo,String userAddress,String userPassword){
        //Complete This -----------------------------------------
        System.out.println("Profile Created");
        GymCustomer gymCustomer = new GymCustomer();
        gymCustomer.setUserName(userName);
        gymCustomer.setUserEmail(EmailId);
        gymCustomer.setPhoneNo(userPhoneNo);
        gymCustomer.setAddress(userAddress);
        gymCustomer.setUserPassword(userPassword);
        return gymCustomer;
    }
    public void updateProfile(GymCustomer gymCustomer){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter What to Update");
        System.out.println("1. To Update Your Name");
        System.out.println("2. To Update Your EmailId");
        System.out.println("3. To Update Your PassWord");
        System.out.println("4. To Update Your Phone Number");
        System.out.println("5. To Update Your Address");
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Your New Name");
                    String newUserName=sc.nextLine();
                    gymCustomer.setUserName(newUserName);
                case 2:
                    System.out.println("Enter Your New EmailId");
                    String newUserEmailId=sc.nextLine();
                    gymCustomer.setUserEmail(newUserEmailId);
                case 3:
                    System.out.println("Enter Your New PassWord");
                    String newUserPassWord=sc.nextLine();
                    gymCustomer.setUserPassword(newUserPassWord);
                case 4:
                    System.out.println("Enter Your New Phone Number");
                    String newUserPhoneNumber=sc.nextLine();
                    gymCustomer.setPhoneNo(newUserPhoneNumber);
                case 5:
                    System.out.println("Enter Your New Address");
                    String newUserAddress=sc.nextLine();
                    gymCustomer.setAddress(newUserAddress);

                default:

            }
        } catch(Exception e){
            System.out.println("Enter Correct Value");
        }

    }
    public String getRole(){
        System.out.println("Role:");
        return "";
    }
    public void viewAllGyms(){

        System.out.println("Gyms Near Your Area:");
        System.out.println("Gym-1");
        System.out.println("Gym-2");


    }
}
