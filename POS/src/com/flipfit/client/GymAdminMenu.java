package com.flipfit.client;

import com.flipfit.business.GymAdminBusinessService;
import com.flipfit.business.SlotBusinessServiceInterfcae;
import com.flipfit.dao.GymOwnerDAO;
import java.util.Scanner;

public class GymAdminMenu {
    public void adminPage() {
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
        System.out.println("8. Logout");
        try {
            int choice = sc.nextInt();
            GymAdminBusinessService gymAdminBusinessService=new GymAdminBusinessService();
            switch (choice) {
                case 1:
                    ApproveGymRegistration();
                    break;
                case 2:
                    AddGym();
                    break;
                case 3:
                    DeleteGym();
                    break;
                case 4:
                    ViewApprovedGyms();
                    break;
                case 5:
                    AddGymOwner();
                    break;
                case 6:
                    DeleteGymOwner();
                    break;
                case 7:
                    ViewPendingGymRequests();
                    break;
                default:
                    System.out.println("Logout Successful");
                    return;

            }
            adminPage();
        } catch(Exception e){
            System.out.println(e);
            System.out.println("Enter Correct Value");
        }
        String a = sc.nextLine();
    }

    void ApproveGymRegistration(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Gym Owner Email:");
        String gymOwnerName = sc.nextLine();

        System.out.println("Enter Gym Name:");
        String gymName = sc.nextLine();

        GymOwnerDAO.approveGym(gymOwnerName, gymName);
    }
    void AddGym(){
        GymOwnerMenu gymOwnerMenu = new GymOwnerMenu();
        gymOwnerMenu.AddGymCenterClient("admin");
    }
    void DeleteGym(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Gym Owner Email:");
        String gymOwnerName = sc.nextLine();

        System.out.println("Enter Gym Name:");
        String gymName = sc.nextLine();

        GymOwnerDAO.DeleteGymCenter(gymOwnerName, gymName);

    }
    void ViewApprovedGyms(){
        GymOwnerDAO.viewApprovedGyms(null);
    }
    void AddGymOwner(){
        GymOwnerMenu gymOwnerMenu = new GymOwnerMenu();
        gymOwnerMenu.AddGymOwnerClient();
    }
    void DeleteGymOwner(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Gym Owner Name:");
        String gymOwnerName = sc.nextLine();

        GymOwnerDAO.DeleteGymOwner(gymOwnerName);
    }
    void ViewPendingGymRequests(){
        GymOwnerDAO.viewPendingGymApprovals();
    }


}
