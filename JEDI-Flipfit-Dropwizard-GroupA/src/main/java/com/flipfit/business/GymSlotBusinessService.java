package com.flipfit.business;

/*
 * @Author : "Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "GymSlotBusinessService"
 * @Description: "Business Service layer for managing gym slot operations within the FlipFit application.
 * This class implements the GymSlotBusinessServiceInterfcae and encapsulates
 * business logic for slot functionalities, such as setting gym center IDs,
 * retrieving customer IDs, and managing slot dates for bookings."
 * @Exceptions: "No specific custom exceptions defined yet, but could include SlotException"
 * @Version : "1.0"
 * @See : "com.flipfit.beans.Slot, com.flipfit.beans.GymCentre, com.flipfit.business.GymSlotBusinessServiceInterfcae"
 *
 *
 */
public class GymSlotBusinessService implements GymSlotBusinessServiceInterfcae {
    public void setGymCenterId(){
        System.out.println("setting the gym center id");
    }
    public int getCustomerId(){
        System.out.println("customerId:");
        return 0;
    }
    public void setSlotDate(){
        System.out.println("setting slot date");
    }
    public int getSlotDate(){
        System.out.println("slotDate:");
        return 0;
    }
}
