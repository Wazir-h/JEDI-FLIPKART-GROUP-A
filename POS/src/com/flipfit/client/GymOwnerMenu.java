package com.flipfit.client;
import com.flipfit.business.GymOwnerBusinessService;

import java.util.Scanner;

public class GymOwnerMenu {
    GymOwnerBusinessService gymOwnerBusinessService = new GymOwnerBusinessService();
     void ownerPage() {

        System.out.println("Welcome Gym Owner");
        System.out.println("Enter your choice: ");
        System.out.println("1. Add Gym Center");
        System.out.println("2. Delete Gym Center");
        System.out.println("3. Edit Slot Details");
        System.out.println("4. View Gym Centers");
        System.out.println("5. View Gym Approved Status");

        System.out.println("6. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }

        switch (choice) {
            case 1:
                AddGymCenterClient();
                break;

            case 2:
                ViewGymCentresClient();
            case 3:

                break;
            default:
                return;
        }
    }
    void AddGymOwnerClient(){
        Scanner scanner = new Scanner(System.in);

        String  gymOwnerName,
                gymEmail,
                gymOwnerAddress,
                gymOwnerPhone,
                GSTNumber,
                location;
        System.out.println("Enter Your Name: ");
        gymOwnerName = scanner.nextLine();

        System.out.println("Enter Your Email: ");
        gymEmail = scanner.nextLine();

        System.out.print("Add Gym Owner Address");
        gymOwnerAddress = scanner.nextLine();

        System.out.print("Add Gym Owner Phone Number: ");
        gymOwnerPhone = scanner.nextLine();

        System.out.print("Add Gym Owner GST number ");
        GSTNumber = scanner.nextLine();

        System.out.print("Add gym owner Location ");
        location = scanner.nextLine();

        gymOwnerBusinessService.AddGymOwnerDetails(gymEmail,gymOwnerName, gymOwnerAddress,
                                                    gymOwnerPhone, GSTNumber, location);
    }
    void AddGymCenterClient(){
        GymOwnerBusinessService gymOwnerBusinessService = new GymOwnerBusinessService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Gym Name: ");
        String GymName =  scanner.nextLine();

        System.out.print("Add Gym Center Address: ");
        String GymCenterAddress = scanner.nextLine();

        System.out.print("Add Gym Center Phone Number: ");
        String GymCenterPhone = scanner.nextLine();

        System.out.print("Enter Total Slot Count: ");
        int SlotCount = scanner.nextInt();

        gymOwnerBusinessService.AddGymCenter(, GymName, GymCenterAddress, GymCenterPhone, SlotCount);
    }
    public static void ViewGymCentresClient(){

    }

    public void DeleteGymCenterClient(){
    }

}
