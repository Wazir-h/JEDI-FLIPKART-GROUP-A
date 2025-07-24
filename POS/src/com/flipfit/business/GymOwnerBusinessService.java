package com.flipfit.business;

import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;
import com.flipfit.dao.GymOwnerDAO;

public class GymOwnerBusinessService implements GymOwnerBusinessServiceInterface {
    public void AddGymOwnerDetails(String gymEmail, String gymOwnerName, String gymOwnerAddress,
                                   String gymOwnerPhone, String GSTNumber, String password) {

          GymOwner gymOwner=new GymOwner();

          gymOwner.setUserName(gymOwnerName);
          gymOwner.setGymOwnerAddress(gymOwnerAddress);
          gymOwner.setGymOwnerPhone(gymOwnerPhone);
          gymOwner.setGSTNumber(GSTNumber);
          String gymId = gymOwnerName+gymOwnerAddress;
          gymOwner.setId(gymId);
          gymOwner.setUserEmail(gymEmail);
          gymOwner.setUserPassword(password);
          GymOwnerDAO.AddGymOwner(gymOwner.getUserEmail(),gymOwner);
          System.out.println("Gym Owner registration Successful");
    }

    public void AddGymCenter(String gymOwnerEmail, String gymCenterName, String gymCenterAddress,
                      String gymCenterPhone, int SlotCount){

        GymCentre gymCenter = new GymCentre();

        gymCenter.setGymName(gymCenterName);
        gymCenter.setGymCenterAddress(gymCenterAddress);
        gymCenter.setSlotCount(SlotCount);
        gymCenter.setGymCenterPhone(gymCenterPhone);
        gymCenter.setUserEmail(gymOwnerEmail);
        String gymID = gymCenterName + gymCenterAddress;
        gymCenter.setGymID(gymID);
        System.out.println(gymCenter);
        GymOwnerDAO.AddGymCenter(gymCenter.getUserEmail(), gymCenter);
        System.out.println("Gym Center registration Successful");
    }
    public void DeleteGymCenter(String userName,  String gymName){
        GymOwnerDAO.DeleteGymCenter(userName,gymName);
    }

    public void EditGymSlot(String userName, String gymName, int SlotCount){
        GymCentre gymCentre = GymOwnerDAO.GetGymCenter(userName,gymName);
        if(gymCentre!=null){
            gymCentre.setSlotCount(SlotCount);
            GymOwnerDAO.DeleteGymCenter(userName,gymName);
            GymOwnerDAO.AddGymCenter(userName,gymCentre);
        }
        else {
            System.out.println("Gym Center not found");
        }
    }

    public void ViewAllGymCenters(String userName){
        GymOwnerDAO.getAllGymCenters(userName);
    }

    public void ViewGymApprovedStatus(String userName, String gymName){
        GymCentre gymCentre = GymOwnerDAO.GetGymCenter(userName,gymName);
        if(gymCentre.isApproved()){
            System.out.println("Gym Center is approved");
        }
        else {
            System.out.println("Gym Center is not approved");
        }
    }
}
