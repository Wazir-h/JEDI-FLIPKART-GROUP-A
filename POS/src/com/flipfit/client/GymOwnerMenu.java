package com.flipfit.client;
import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;
import com.flipfit.business.GymOwnerBusinessService;

import java.util.Scanner;

public class GymOwnerMenu {
    public static void ownerPage() {

        System.out.println("Welcome Gym Owner");
        System.out.println("Enter your choice: ");
        System.out.println("1. Add Gym Center");
        System.out.println("2. View Gym Centers");
        System.out.println("3. Exit");

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
                break;
            default:
                return;
        }
    }
    public static GymOwner AddGymOwnerClient(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add Gym Owner Address");
        String GymOwnerAddress = scanner.nextLine();

        System.out.print("Add Gym Owner Phone Number: ");
        String GymOwnerPhone = scanner.nextLine();

        System.out.print("Add Gym Owner GST number ");
        String GSTNumber = scanner.nextLine();

        System.out.print("Add gym owner Location ");
        String location = scanner.nextLine();

        GymOwner gymOwner=GymOwnerBusinessService.AddGymOwnerDetails(GymOwnerAddress , GymOwnerPhone,GSTNumber,location);
         return gymOwner;
    }
    public static GymCentre AddGymCenterClient(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Gym Name: ");
        String GymName =  scanner.nextLine();

        System.out.print("Add Gym Center Address");
        String GymCenterAddress = scanner.nextLine();

        System.out.print("Add Gym Center Phone Number: ");
        String GymCenterPhone = scanner.nextLine();

        System.out.print("Enter Total Slot Count");
        int SlotCount = scanner.nextInt();

        GymCentre gym = GymOwnerBusinessService.AddGymCenter(GymName, GymCenterAddress, GymCenterPhone, SlotCount);
        return gym;

    }
    public static void ViewGymCentresClient(){

    }

    public void DeleteGymCenterClient(){
    }

}
