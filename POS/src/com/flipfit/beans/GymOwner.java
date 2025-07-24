package com.flipfit.beans;

public class GymOwner extends User {
    private String gymOwnerAddress;
    private String gymOwnerPhone;
    private String GSTNumber;
    private boolean isApproved = false;

    public String getGymOwnerPhone() {
        return gymOwnerPhone;
    }

    public void setGymOwnerPhone(String gymOwnerPhone) {
        this.gymOwnerPhone = gymOwnerPhone;
    }

    public String getGymOwnerAddress() {
        return gymOwnerAddress;
    }

    public void setGymOwnerAddress(String gymOwnerAddress) {
        this.gymOwnerAddress = gymOwnerAddress;
    }

    public String getGSTNumber() {
        return GSTNumber;
    }

    public void setGSTNumber(String GSTNumber) {
        this.GSTNumber = GSTNumber;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = true;
    }

    @Override
    public String toString() {
        return "Gym Owner Name: " + getUserName() + "\nGym Owner ID: " + getUserId();
    }

}