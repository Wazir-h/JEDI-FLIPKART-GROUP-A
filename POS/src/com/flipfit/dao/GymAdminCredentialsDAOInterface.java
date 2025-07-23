package com.flipfit.dao;

import com.flipfit.beans.GymOwner;

import java.util.List;

public interface GymAdminCredentialsDAOInterface {
    public String getAdminData(String key);
    public void printAllData();
    public void setAdminCred();
    public boolean authenticateUser(String username, String password);
    public boolean userExists(String username);
    public List<GymOwner> getAllOwners();
    public void removeGymOwner(String userName);
    public void removeGym(String ownerUserName, String gymCenterID);
    public boolean approveGym(String ownerUserName, String gymCenterID);
    public boolean approveGymOwner(String userName);
}
