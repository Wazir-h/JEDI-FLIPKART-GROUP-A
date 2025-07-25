package com.flipfit.business;

import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.dao.GymOwnerDAO;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique"
 * @ClassName: "GymOwnerBusinessService"
 * @Description: "Business Service layer for managing operations related to Gym Owners.
 * This class implements the GymOwnerBusinessServiceInterface and encapsulates
 * business logic for gym owner functionalities, such as registering gym centers,
 * managing their profiles, and interacting with data access objects (DAOs)."
 * @Exceptions: "Custom business exceptions (e.g., GymOwnerNotFoundException, GymAlreadyExistsException)" // Or specific exceptions it might throw
 * @Version : "1.0"
 * @See : "com.flipfit.beans.GymCentre, com.flipfit.beans.GymOwner, com.flipfit.dao.GymOwnerDAO, com.flipfit.business.GymOwnerBusinessServiceInterface"
 *
 *
 */

public class GymOwnerBusinessService implements GymOwnerBusinessServiceInterface {
    public void AddGymOwnerDetails(String gymEmail, String gymOwnerName, String gymOwnerAddress,
                                   String gymOwnerPhone, String GSTNumber, String password) {

          GymOwner gymOwner=new GymOwner();

          gymOwner.setUserName(gymOwnerName);
          gymOwner.setGymOwnerAddress(gymOwnerAddress);
          gymOwner.setGymOwnerPhone(gymOwnerPhone);
          gymOwner.setGSTNumber(GSTNumber);
          String gymId = gymOwnerName;
          gymOwner.setRoleid("3");
          gymOwner.setUserId(gymEmail);
          gymOwner.setUserEmail(gymEmail);
          gymOwner.setUserPassword(password);
          GymOwnerDAO.AddGymOwner(gymOwner.getUserEmail(),gymOwner);

//          System.out.println("Gym Owner registration Successful");
    }

    public void AddGymCenter(String gymOwnerEmail, String gymCenterName, String gymCenterAddress,
                      String gymCenterPhone, int SlotCount){

        GymCentre gymCenter = new GymCentre();

        gymCenter.setGymName(gymCenterName);
        gymCenter.setGymCenterAddress(gymCenterAddress);
        gymCenter.setSlotCount(SlotCount);
        gymCenter.setGymCenterPhone(gymCenterPhone);
        gymCenter.setUserEmail(gymOwnerEmail);
        String gymID = gymCenterName;
        gymCenter.setGymID(gymID);

        System.out.println(gymCenter.getUserEmail());
        GymOwnerDAO.AddGymCenter(gymCenter.getUserEmail(), gymCenter);
//        System.out.println("Gym Center registration Successful");
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
