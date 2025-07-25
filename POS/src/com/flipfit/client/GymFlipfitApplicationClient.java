package com.flipfit.client;
import java.util.Scanner;

import com.flipfit.business.GymCustomerBusinessService;
import com.flipfit.business.GymOwnerBusinessService;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.beans.GymCustomer;
import com.flipfit.dao.GymOwnerDAO;

public class GymFlipfitApplicationClient {
    public GymOwnerMenu gymOwnerMenu = new GymOwnerMenu();

    void userLogin() {
        // RoleId - 1: Gym Admin, RoleId - 2: Gym Customer, RoleId - 3: Gym Owner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.println("Enter Your Role Number:");
        System.out.println("1. Gym Admin");
        System.out.println("2. Gym Customer");
        System.out.println("3. Gym Owner");
        int roleId = scanner.nextInt();

        GymAdminMenu gymAdminMenu = new GymAdminMenu();
        if (roleId == 1) {
            if(GymAdminDAO.authenticateUser(userName,password)){
                gymAdminMenu.adminPage();
            }else{
                System.out.println("Login Failed");
            }
        }
        else if (roleId == 2) {
            if(GymCustomerDAO.authenticateUser(userName,password)){
                GymCustomerMenu.customerPage(userName,password,3);
            }else{
                System.out.println("\n Login Failed");
            }
        }
        else if (roleId == 3) {
            if(GymOwnerDAO.authenticateUser(userName,password)){
                gymOwnerMenu.ownerPage(userName);
            }else{
                System.out.println("\n Login Failed");
            }
        }
        else {
            System.out.println("Please Enter correct RoleId");
        }
    }

    public void GymCustomerRegistration() {
        GymCustomer newCustomer = GymCustomerMenu.AddGymCustomer();       // -----------------------------------------

        GymCustomerDAO.addCustomer(newCustomer.getUserEmail(), newCustomer);
        System.out.println("Gym Customer Registration Successful");
    }

    public void GymOwnerRegistration() {
        gymOwnerMenu.AddGymOwnerClient();
    }

    public void changePassword() {
        System.out.println("Password Changed Successful");
    }

     void Main() {
        // Welcome Message to User
        GymAdminDAO.setAdminCred();
        System.out.println("Welcome to Flipfit Application");

//        //Add Dummy Data for customers
//         GymCustomerBusinessService.createProfile("user1", "user1", "123", "abc", "abc");
//         GymCustomerBusinessService.createProfile("user2", "user2", "123", "abc", "abc");


        // Add Dummy Data for GymOwners and Gym Centers
         GymOwnerBusinessService gymOwnerService = new GymOwnerBusinessService();

         gymOwnerService.AddGymOwnerDetails("owner1@example.com", "Fitness Pro", "123 Gym St, City", "9876543210", "GSTIN12345", "owner1pass");
         gymOwnerService.AddGymCenter("owner1@example.com", "Fitness Pro Gym", "123 Gym St, City", "9876543210", 10);
         gymOwnerService.AddGymCenter("owner1@example.com", "Pro Strength Hub", "456 Power Ave, Town", "9876543211", 8);

         gymOwnerService.AddGymOwnerDetails("owner2@example.com", "Health Haven", "789 Wellness Rd, Village", "9988776655", "GSTIN67890", "owner2pass");
         gymOwnerService.AddGymCenter("owner2@example.com", "Health Haven Center", "789 Wellness Rd, Village", "9988776655", 12);

         gymOwnerService.AddGymOwnerDetails("owner3@example.com", "CultFit", "ETV", "9988776655", "GSTIN67890", "owner3pass");
         gymOwnerService.AddGymCenter("owner3@example.com", "CultFit Pro", "ETV", "9988776655", 12);

         // Scanner Object for User Inputs
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("1. Login User");
            System.out.println("2. Registration for Gym Customer");
            System.out.println("3. Registration for Gym Owner");
            System.out.println("4. Change password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Read the User choice
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    userLogin();
                    break;

                case 2:
                    GymCustomerRegistration();
                    break;

                case 3:
                    GymOwnerRegistration();
                    break;

                case 4:
                    changePassword();
                    break;

                default:
                    return;
            }
        }
    }
    public static void main(String[] args) {

        GymFlipfitApplicationClient app = new GymFlipfitApplicationClient();
        app.Main();
    }

}
