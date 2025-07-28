package com.flipfit.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique"
 * @ClassName: "GymAdminDAO"
 * @Description: "Data Access Object (DAO) for managing Gym Administrator related data.
 * This class handles database operations pertinent to gym administrators, such as
 * managing gym centers, reviewing owner requests, and overall system configuration."
 * @Exceptions: "SQLException - Thrown for database access errors during JDBC operations."
 * @Version : "1.0"
 * @See : "com.flipfit.beans.GymCentre, com.flipfit.beans.GymOwner, com.flipfit.constant.SqlQueries"
 *
 *
 */

public class GymAdminDAO {
    public static Map<String, String> AdminCred = new HashMap<>();

    public static void addData(String key, String value) {
        AdminCred.put(key, value);
    }

    public static String getAdminData(String key) {
        return AdminCred.get(key);
    }

    public void printAllData() {
        System.out.println("Current Admin data: " + AdminCred);
    }

    public static void setAdminCred() {
        // System.out.println("\n--- Setting Up Admin Credentials ---");
        GymAdminDAO.addData("admin1", "admin1");
        GymAdminDAO.addData("admin2", "admin2");
        // GymAdminDAO.printAllData();
    }

    public static boolean authenticateUser(String username, String password) {
        System.out.println(username + password);
        if (AdminCred.containsKey(username)) {
            String storedPassword = AdminCred.get(username);
            return storedPassword.equals(password);
        }
        return false; // User does not exist
    }

    public void getAllOwners(){
        System.out.println("All Gym Owners");
        GymOwnerDAO.getAllGymOwners();
    };

    public void removeGymOwner(String ownerUsername){
        GymOwnerDAO.DeleteGymOwner(ownerUsername);
    };

    public void removeGym(String ownerUserName, String gymCenterID){
        GymOwnerDAO.DeleteGymCenter(ownerUserName,gymCenterID);
    };

    public void approveGymCenter(String ownerUserName, String gymCenterID){
        GymOwnerDAO.approveGym(ownerUserName, gymCenterID);
    };
}