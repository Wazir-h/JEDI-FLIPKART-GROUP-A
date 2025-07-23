package com.flipfit.beans;

public interface GymCentre extends GymOwner {

    private String GymCenterAddress;
    private boolean isApproved;
    private int SlotCount;
    private String GymName;
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
    public void getGymName(){return  GymName;}
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

    private String GymID;
    private String GymCenterPhone;

}