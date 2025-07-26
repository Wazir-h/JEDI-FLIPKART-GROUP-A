package com.flipfit.client;
import com.flipfit.beans.GymCentre;
import  com.flipfit.beans.GymCustomer;
import com.flipfit.beans.GymOwner;
import com.flipfit.business.GymCustomerBusinessService;
import com.flipfit.business.GymCustomerBusinessServiceInterface;
import com.flipfit.dao.GymCustomerDAO;

import java.util.Scanner;
/*
 * @Author : "Trilekya, Shivansh Sinha, Sujal Mishra, Yashvardhan Yadav"
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
public class GymCustomerMenu {
    public static void customerPage(String userName,String userPassword,int roleId){
        GymCustomer gymCustomer=new GymCustomer();
        GymCustomerDAO.loadBookingDetails(userName);
        gymCustomer.setUserName(userName);
        gymCustomer.setUserPassword(userPassword);
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf ("              Welcome %-68s ║\n", userName + " to FlipFit");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                            🧍‍♂️ Customer Dashboard 🧍‍♀️                            ");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                                 ║");
        System.out.println("║   1. Update Profile                                                             ║");
        System.out.println("║   2. View All Gyms                                                              ║");
        System.out.println("║   3. View All Bookings                                                          ║");
        System.out.println("║   4. Book Slot                                                                  ║");
        System.out.println("║   5. Cancel Slot                                                                ║");
        System.out.println("║   6. View Available Slots                                                       ║");
        System.out.println("║   7. Log Out                                                                    ║");
        System.out.println("║                                                                                 ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
        System.out.print("👉 Enter option to move next (1–7): ");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
            switch (choice) {
                case 1:
                    gymCustomerBusinessService.updateProfile(gymCustomer);
                    break;
                case 2:
                    gymCustomerBusinessService.viewAllGyms();
                    break;
                case 3:
                    gymCustomerBusinessService.viewAllBookings(userName);
                    break;
                case 4:
                    gymCustomerBusinessService.bookSlot(userName);
                    break;
                case 5:
                    gymCustomerBusinessService.cancelSlot(userName);
                    break;
                case 6:
                    gymCustomerBusinessService.viewAllAvailableSlots();
                    break;
                default:
                    System.out.println("Logout Successful");
                    return;
            }
            customerPage(userName, userPassword,roleId);
        } catch(Exception e){
            System.out.println("Enter Correct Value");
            customerPage(userName, userPassword,roleId);
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
