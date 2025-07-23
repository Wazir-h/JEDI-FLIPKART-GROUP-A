package com.flipfit.client;
import com.flipfit.beans.GymCentre;
import  com.flipfit.beans.GymCustomer;
import com.flipfit.beans.GymOwner;
import com.flipfit.business.GymCustomerBusinessService;
import com.flipfit.business.GymCustomerBusinessServiceInterface;

import java.util.Scanner;

public class GymCustomerMenu {
    public static void customerPage(String userName,String userPassword,int roleId){
        GymCustomer gymCustomer=new GymCustomer();
        gymCustomer.setUserName(userName);
        gymCustomer.setUserPassword(userPassword);
        System.out.println("Welcome "+ userName + " to Flipfit");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter option to Move Next");
        System.out.println("1. To UpdateProfile");
		System.out.println("2. To View All Gyms");
        System.out.println("3. Book Slot");
        System.out.println("4. Cancel Slot");

        try {
            int choice = sc.nextInt();
            GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
            switch (choice) {
                case 1:
                    gymCustomerBusinessService.updateProfile(gymCustomer);
                case 2:
                    gymCustomerBusinessService.viewAllGyms();
                case 3:
                    gymCustomerBusinessService.bookSlot();
                case 4:
                    gymCustomerBusinessService.cancelSlot();
                default:

            }
        } catch(Exception e){
            System.out.println("Enter Correct Value");
        }
    }
    public static GymCustomer AddGymCustomer(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Add Gym Customer Name \t");
        String GymOwnerName = scanner.nextLine();

        System.out.print("Add Gym Customer EmailId \t");
        String GymOwnerEmailId = scanner.nextLine();

        System.out.print("Add Gym Customer Phone Number \t");
        String GymOwnerPhoneNo = scanner.nextLine();

        System.out.print("Add Gym Customer Address \t");
        String GymOwnerAddress = scanner.nextLine();

        System.out.print("Add Your Password \t");
        String GymOwnerPassword = scanner.nextLine();
        GymCustomer gymCustomer = GymCustomerBusinessService.createProfile(GymOwnerName,GymOwnerEmailId,GymOwnerPhoneNo,GymOwnerAddress,GymOwnerPassword);
        return gymCustomer;
    }

}
