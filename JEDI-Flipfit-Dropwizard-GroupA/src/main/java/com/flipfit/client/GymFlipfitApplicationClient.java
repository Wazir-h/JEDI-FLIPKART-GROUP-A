package com.flipfit.client;
import java.util.Scanner;

import com.flipfit.business.GymCustomerBusinessService;
import com.flipfit.business.GymOwnerBusinessService;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.beans.GymCustomer;
import com.flipfit.dao.GymOwnerDAO;
/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Yashvardhan Yadav"
 * @ClassName: "GymOwnerMenu"
 * @Description: "Provides the command-line interface (CLI) menu for Gym Owners.
 * This class handles user input and orchestrates calls to the GymOwnerBusinessService
 * to perform actions such as managing gym centers, viewing requests, and updating profiles."
 * @Exceptions: "InputMismatchException (for Scanner issues), or custom exceptions from business layer."
 * @Version : "1.0"
 * @See : "com.flipfit.business.GymOwnerBusinessService, java.util.Scanner"
 *
 *
 */
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

         GymOwnerBusinessService gymOwnerService = new GymOwnerBusinessService();

         // Scanner Object for User Inputs
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                              🙏 Welcome to FlipFit 🙏                             ");
            System.out.println("╠═════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                                                 ║");
            System.out.println("║   1. Login User                                                                 ║");
            System.out.println("║   2. Registration for Gym Customer                                              ║");
            System.out.println("║   3. Registration for Gym Owner                                                 ║");
            System.out.println("║   4. Change Password                                                            ║");
            System.out.println("║   5. Exit                                                                       ║");
            System.out.println("║                                                                                 ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print("👉 Enter your choice (1-5): ");

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
