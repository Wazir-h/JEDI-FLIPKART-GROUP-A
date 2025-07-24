package com.flipfit.business;

import com.flipfit.client.GymOwnerMenu;

public class GymAdminBusinessService implements GymAdminBusinessServiceInterface {

    public void ViewPendingGymRequests(){
        System.out.println("Searching for pending Gym Requests");
        if (true) {
            System.out.println("No pending gym registration requests found.");
        } else {
            System.out.println("--- Pending Gym Requests ---");
            System.out.println("----------------------------");
        }
    }
    public void ApproveGymRegistration(){
        System.out.println("Gym request approved");
    }
    public void ViewApprovedGyms(){
        System.out.println("Following are the list of approved gyms");
    }
    public void AddGymOwner(){
        System.out.println("Gym owner added successfully");
    }
    public void DeleteGymOwner(){System.out.println("Gym owner deleted successfully");}


    public void AddGym(){
    }
    public void DeleteGym(){
        System.out.println("Gym delete added successfully");
    }

}
