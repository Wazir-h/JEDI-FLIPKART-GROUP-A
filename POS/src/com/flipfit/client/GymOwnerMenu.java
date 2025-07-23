package com.flipfit.client;
import com.flipfit.beans.GymCentre;
import com.flipfit.business.GymOwnerBusinessService;

import java.util.Scanner;

public class GymOwnerMenu {
    public void AddGymOwnerClient(){
        Scanner scanner = new Scanner(System.in);


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
