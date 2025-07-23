package com.flipfit.client;
import java.util.Scanner;

import com.flipfit.beans.GymOwner;
import com.flipfit.business.GymOwnerBusinessService;
import com.flipfit.dao.GymAdminCredentialsDAO;
import com.flipfit.dao.GymCustomerCredentialsDAO;
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


        if (roleId == 1) {
            if(GymAdminCredentialsDAO.authenticateUser(userName,password)){
                GymAdminMenu.adminPage();
            }else{
                System.out.println("Login Failed");
            }
        }
        else if (roleId == 2) {
            if(GymCustomerCredentialsDAO.authenticateUser(userName,password)){
                GymCustomerMenu.customerPage(userName,password,3);
            }else{
                System.out.println("\n Login Failed");
            }
        }
        else if (roleId == 3) {
            if(GymOwnerDAO.authenticateUser(userName,password)){
                gymOwnerMenu.ownerPage();
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

        GymCustomerCredentialsDAO.addCustomer(newCustomer.getUserEmail(), newCustomer);
        System.out.println("Gym Customer Registration Successful");
    }

    public void GymOwnerRegistration() {
        gymOwnerMenu.AddGymOwnerClient();
    }

    public void changePassword() {
        System.out.println("Password Changed Successful");
    }

    public void main(String[] args) {
        // Welcome Message to User
        GymAdminCredentialsDAO.setAdminCred();
        System.out.println("Welcome to Flipfit Application");

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
}
