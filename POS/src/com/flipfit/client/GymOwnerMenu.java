package com.flipfit.client;
import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;
import com.flipfit.business.GymOwnerBusinessService;

import java.util.Scanner;

public class GymOwnerMenu {
    public static void ownerPage() {

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

        GymOwner gymOwner=GymOwnerBusinessService.AddGymOwnerDetails(string gymOwnerAddress , String gymOwnerPhone,String GSTNumber,String location);
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
    public void ViewGymCentresClient(){

    }

    public void DeleteGymCenterClient(){
    }

}
