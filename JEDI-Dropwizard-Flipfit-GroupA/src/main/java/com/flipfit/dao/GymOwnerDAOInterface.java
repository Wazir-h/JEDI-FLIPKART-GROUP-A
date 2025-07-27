package com.flipfit.dao;
import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;

import java.util.List;

public interface GymOwnerDAOInterface{
    public  void AddGymOwner(String username, GymOwner owner);
    public  void AddGymCenter(String ownerEmail, GymCentre gymCenter);
    public  void DeleteGymCenter(String ownerEmail, String gymName);
    public  GymCentre GetGymCenter(String ownerEmail, String gymName);
    public  void getAllGymCenters(String userName);
    public  void getAllGyms();
    public  void getAllOwners();
    public  GymOwner getGymOwnerDetail(String username);
    public  boolean authenticateUser(String username, String password);
    public  boolean userExists(String username);

}
