package com.flipfit.business;

public class GymAdminBusinessService implements GymAdminBusinessServiceInterface {

    public void ViewPendingGymRequests(){
        System.out.println("Following are the list of pending requests");
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
        System.out.println("Gym added successfully");
    }

    public void DeleteGym(){
        System.out.println("Gym delete added successfully");
    }

}
