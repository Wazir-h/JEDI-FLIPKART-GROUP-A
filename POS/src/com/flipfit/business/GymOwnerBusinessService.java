package com.flipfit.business;

import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;
import com.flipfit.dao.GymOwnerDAO;

public class GymOwnerBusinessService implements GymOwnerBusinessServiceInterface {
    public void AddGymOwnerDetails(String gymEmail, String gymOwnerName, String gymOwnerAddress,
                                   String gymOwnerPhone, String GSTNumber, String location){

          GymOwner gymOwner=new GymOwner();

          gymOwner.setName(gymOwnerName);
          gymOwner.setGymOwnerAddress(gymOwnerAddress);
          gymOwner.setGymOwnerPhone(gymOwnerPhone);
          gymOwner.setGSTNumber(GSTNumber);
          gymOwner.setLocation(location);
          String gymId = gymOwnerName+gymOwnerName;
          gymOwner.setId(gymId);
          gymOwner.setUserEmail(gymEmail);

          GymOwnerDAO.AddGymOwner(gymOwner.getUserEmail(),gymOwner);
          System.out.println("Gym Owner registration Successful");
    }

    public void AddGymCenter(String gymOwnerEmail, String gymCenterName, String gymCenterAddress,
                      String gymCenterPhone, int SlotCount){
        GymCentre gymCenter = new GymCentre();

        gymCenter.setName(gymCenterName);
        gymCenter.setGymCenterAddress(gymCenterAddress);
        gymCenter.setSlotCount(SlotCount);
        gymCenter.setGymCenterPhone(gymCenterPhone);
        gymCenter.setUserEmail(gymOwnerEmail);
        String gymID = gymCenterName + gymCenterAddress;
        gymCenter.setGymID(gymID);

        GymOwnerDAO.AddGymCenter(gymCenter.getUserEmail(), gymCenter);
        System.out.println("Gym Center registration Successful");
    }
    public void DeleteGymCenter(){
    }

    public void EditGymSlot(){

    }


    public void ViewAllGymCenters(){
    }
    public void ViewAllGymSlots(){
    }

    public void ViewGymApprovedStatus(){

    }
}
