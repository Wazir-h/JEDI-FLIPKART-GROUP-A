package com.flipfit.client;
import java.util.Scanner;

public class GymFlipfitApplicationClient {
    public static void userLogin(String userName, String userPassword, int roleId) {
        // RoleId - 1: Gym Admin, RoleId - 2: Gym Customer, RoleId - 3: Gym Owner
        System.out.println("Login Successful");

        if (roleId == 1) {
            GymAdminMenu.adminPage();
        } else if (roleId == 2) {
            GymCustomerMenu.customerPage(userName,userPassword,roleId);
        } else if (roleId == 3) {
            GymOwnerMenu.ownerPage();
        } else {
            System.out.println("Please Enter correct RoleId");
        }
    }

    public static void GymCustomerRegistration() {
        System.out.println("Gym Customer Registration Successful");
    }

    public static void GymOwnerRegistration() {
        System.out.println("Gym Owner registration Successful1");
    }

    public static void changePassword() {
        System.out.println("Password Changed Successful");
    }

    public static void main(String[] args) {
        // Welcome Message to User
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
                    userLogin("userName", "userPassword", 1);
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
