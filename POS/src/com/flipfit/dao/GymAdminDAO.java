package com.flipfit.dao;

import java.util.HashMap;
import java.util.Map;
public class GymAdminDAO{
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
//        System.out.println("\n--- Setting Up Admin Credentials ---");
        GymAdminDAO.addData("admin1", "admin1");
        GymAdminDAO.addData("admin2", "admin2");
//        GymAdminDAO.printAllData();
    }

    public static boolean authenticateUser(String username, String password) {
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