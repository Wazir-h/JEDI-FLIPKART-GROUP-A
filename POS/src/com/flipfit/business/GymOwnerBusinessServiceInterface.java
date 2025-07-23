package com.flipfit.business;

import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;

public interface GymOwnerBusinessServiceInterface {
    public GymOwner AddGymOwnerDetails(String gymOwnerName, String gymOwnerAddress, String gymOwnerPhone,
                                              String GSTNumber, String location);

    public GymCentre AddGymCenter(String gymCenterName, String gymCenterAddress, String gymCenterPhone, int SlotCount);
    public void DeleteGymCenter();
    public void EditGymSlot();
    public void ViewAllGymCenters();
    public void ViewGymApprovedStatus();
}
