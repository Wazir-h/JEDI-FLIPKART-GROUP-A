package com.flipfit.beans;

public class GymCentre extends GymOwner {

    private String GymCenterAddress;
    private boolean isApproved;
    private int SlotCount;
    private String GymID;
    private String GymCenterPhone;

    public String getGymCenterAddress() {
        return GymCenterAddress;
    }

    public void setGymCenterAddress(String gymCenterAddress) {
        this.GymCenterAddress = gymCenterAddress;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }

    public int getSlotCount() {
        return SlotCount;
    }

    public void setSlotCount(int slotCount) {
        this.SlotCount = slotCount;
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



}