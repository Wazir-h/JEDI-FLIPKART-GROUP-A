package com.flipfit.dao;
import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;

import java.utils.List;

public interface GymOwnerDAOInterface {
    public static void AddGymOwner(String username, GymOwner owner);
    public static void AddGymCenter(String ownerEmail, GymCentre gymCenter);
    public static void DeleteGymCenter(String ownerEmail, String gymName);
    public static GymCentre GetGymCenter(String ownerEmail, String gymName);
    public static void getAllGymCenters(String userName);
    public static void getAllGyms();
    public static void getAllOwners();
    public static GymOwner getGymOwnerDetail(String username);
    public static boolean authenticateUser(String username, String password);
    public static boolean userExists(String username);

    }
