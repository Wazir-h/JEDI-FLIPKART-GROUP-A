package com.flipfit.business;

import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;

public class GymOwnerBusinessService{
    public void AddGymOwnerDetails(string gymOwnerAddress , String gymOwnerPhone,String GSTNumber,String location){
          GymOwner gymOwner=new GymOwner();

          gymOwner.setGymOwnerAddress(gymOwnerAddress);
          gymOwner.setGymOwnerPhone(gymOwnerPhone);
          gymOwner.setGSTNumber(GSTNumber);
          gymOwner.setlocation(location);

          return gymOwner;
    }

    public static GymCentre AddGymCenter(String gymCenterName, String gymCenterAddress, String gymCenterPhone, int SlotCount){
        GymCentre gymCenter = new GymCentre();

        gymCenter.setName(gymCenterName);
        gymCenter.setGymCenterAddress(gymCenterAddress);
        gymCenter.setSlotCount(SlotCount);
        gymCenter.setGymCenterPhone(gymCenterPhone);

        String gymID = gymCenterName + gymCenterAddress;
        gymCenter.setId(gymID);

        return gymCenter;
    }
    public void DeleteGymCenter(){
    }

    public void AddGymSlot(){

    }

    public void DeleteGymSlot(){

    }

    public void ViewAllGymCenters(){
    }
    public void ViewAllGymSlots(){
    }

    public void ViewGymApprovedStatus(){

    }
}
