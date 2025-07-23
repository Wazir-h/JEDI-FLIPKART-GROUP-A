package com.flipfit.client;
import  com.flipfit.beans.GymCustomer;
import com.flipfit.business.GymCustomerBusinessService;
import java.util.Scanner;

public class GymCustomerMenu {
    public static void CustomerPage(String userName,String userPassword,int roleId){
        GymCustomer gymUser = new GymCustomer();
        gymUser.setUserName(userName);
        gymUser.setUserPassword(userPassword);
        System.out.println("Welcome"+ gymUser.getUserName()+ "to Flipfit");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter option to Move Next");
        System.out.println("1. To UpdateProfile");
		System.out.println("2. To View All Gyms");
        try {
            int choice = sc.nextInt();
            GymCustomerBusinessService gymCustomerBusinessService=new GymCustomerBusinessService();
            switch (choice) {
                case 1:
                    gymCustomerBusinessService.updateProfile(gymUser);
                case 2:
                    gymCustomerBusinessService.viewAllGyms();
                default:

            }
        } catch(Exception e){
            System.out.println("Enter Correct Value");
        }
    }

}
