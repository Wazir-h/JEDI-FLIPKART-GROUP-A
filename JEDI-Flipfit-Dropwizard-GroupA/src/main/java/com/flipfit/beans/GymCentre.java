 package com.flipfit.beans;


/*
 * @Author : "Shivansh Sinha"
 * @ClassName: "GymCentre"
 * @Version : "1.0"
 */
public class GymCentre extends GymOwner {

    private String GymCenterAddress;
    private boolean isApproved = false;
    private int SlotCount;
    private String GymName;
    private String GymID;
    private String GymCenterPhone;

    public String getGymCenterAddress() {
        return GymCenterAddress;
    }
    public void setGymCenterAddress(String gymCenterAddress) {
        GymCenterAddress = gymCenterAddress;
    }
    public boolean isApproved() {
        return isApproved;
    }
    public void setApproved(boolean approved) {
        isApproved = approved;
    }
    public void setGymName(String gymName){GymName=gymName;}
    public String getGymName() {return  GymName;}
    public int getSlotCount() {
        return SlotCount;
    }
    public void setSlotCount(int slotCount) {
        SlotCount = slotCount;
    }

    public String getGymID() {
        return GymID;
    }

    public void setGymID(String gymID) {
        GymID = gymID;
    }

    public String getGymCenterPhone() {
        return GymCenterPhone;
    }

    public void setGymCenterPhone(String gymCenterPhone) {
        GymCenterPhone = gymCenterPhone;
    }

    @Override
    public String toString() {
        return String.format("%-30s %-40s %-15d %-50s %-15s%n",
                getGymName(),
                getGymCenterAddress(),
                getSlotCount(),
                getGymID(),
                isApproved()?"Approved":"Not Approved"
        );
    }
}