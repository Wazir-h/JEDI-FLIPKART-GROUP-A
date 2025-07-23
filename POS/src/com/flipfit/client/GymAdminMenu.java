package com.flipfit.client;

import com.flipfit.business.GymAdminBusinessService;
import com.flipfit.business.SlotBusinessServiceInterfcae;

import java.util.Scanner;

public class GymAdminMenu {
    public static void adminPage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Admin Page loaded Successfully");
        System.out.println("Please enter your choice:");
        System.out.println("1. Approve Gyms");
        System.out.println("2. Add Gyms");
        System.out.println("3. Delete Gyms");
        System.out.println("4. View Approved Gyms");
        System.out.println("5. Add Gym Owner");
        System.out.println("6. Delete Gym Owner");
        System.out.println("7. View Pending Gym Request");
        try {
            int choice = sc.nextInt();
            GymAdminBusinessService gymAdminBusinessService=new GymAdminBusinessService();
            switch (choice) {
                case 1:
                    gymAdminBusinessService.ApproveGymRegistration();
                case 2:
                    gymAdminBusinessService.AddGym();
                case 3:
                    gymAdminBusinessService.DeleteGym();
                case 4:
                    gymAdminBusinessService.ViewApprovedGyms();
                case 5:
                    gymAdminBusinessService.AddGymOwner();
                case 6:
                    gymAdminBusinessService.DeleteGymOwner();
                case 7:
                    gymAdminBusinessService.ViewPendingGymRequests();
            }
        } catch(Exception e){
            System.out.println("Enter Correct Value");
        }
        String a = sc.nextLine();
    }
}
