package com.flipfit.dao;

import com.flipfit.beans.GymOwner;

import java.util.List;

public interface GymAdminDAOInterface {
    public String getAdminData(String key);
    public void printAllData();
    public boolean userExists(String username);
    public void getAllOwners();
    public void removeGymOwner(String userName);
    public void removeGym(String ownerUserName, String gymCenterID);
    public boolean approveGymOwner(String userName);
    public void approveGymCenter(String ownerUserName, String gymCenterID);
}
