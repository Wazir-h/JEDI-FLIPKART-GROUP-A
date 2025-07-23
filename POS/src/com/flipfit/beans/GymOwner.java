package com.flipfit.beans;

public class GymOwner extends User {
    private String gymOwnerAddress;
    private String gymOwnerPhone;
    private String GSTNumber;
    private boolean isApproved;
    private String location;


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
        isApproved = approved;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}