package com.flipfit.business;

public interface GymAdminBusinessServiceInterface {
    public void ViewPendingGymRequests();
    public void ApproveGymRegistration();
    public void ViewApprovedGyms();
    public void AddGymOwner();
    public void DeleteGymOwner();
    public void AddGym();
    public void DeleteGym();
}
