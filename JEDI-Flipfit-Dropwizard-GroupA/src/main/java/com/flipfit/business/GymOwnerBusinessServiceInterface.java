package com.flipfit.business;

import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;

public interface GymOwnerBusinessServiceInterface {

    public GymOwner AddGymOwnerDetails(String gymEmail, String gymOwnerName, String gymOwnerAddress,
                                       String gymOwnerPhone, String GSTNumber, String password);

    public GymCentre AddGymCenter(String gymOwnerId, String gymCenterName, String gymCenterAddress,
                                  String gymCenterPhone, int SlotCount);
    public void DeleteGymCenter(String userName,  String gymName);
    public void EditGymSlot(String userName, String gymName, int SlotCount);
    public void ViewAllGymCenters(String userName);
    public void ViewGymApprovedStatus(String userName, String gymName);
}
