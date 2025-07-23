package com.flipfit.business;

public interface GymOwnerBusinessServiceInterface {

    public void AddGymOwnerDetails(String gymEmail, String gymOwnerName, String gymOwnerAddress,
                                   String gymOwnerPhone, String GSTNumber, String location);

    public void AddGymCenter(String gymOwnerId, String gymCenterName, String gymCenterAddress,
                             String gymCenterPhone, int SlotCount);
    public void DeleteGymCenter();
    public void EditGymSlot();
    public void ViewAllGymCenters();
    public void ViewGymApprovedStatus();
}
