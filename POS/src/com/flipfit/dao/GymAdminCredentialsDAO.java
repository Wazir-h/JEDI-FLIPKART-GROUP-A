package com.flipfit.dao;
import com.flipfit.beans.GymOwner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GymAdminCredentialsDAO {
    public static Map<String, String> AdminCred = new HashMap<>();

    public static void addData(String key, String value) {
        AdminCred.put(key, value);
    }

    public static String getAdminData(String key) {
        return AdminCred.get(key);
    }

    public static void printAllData() {
        System.out.println("Current Admin data: " + AdminCred);
    }

    public static void setAdminCred() {
//        System.out.println("\n--- Setting Up Admin Credentials ---");
        GymAdminCredentialsDAO.addData("admin1@flipkart.com", "passwordAdmin1");
        GymAdminCredentialsDAO.addData("admin2@flipkart.com", "passwordAdmin2");
        GymAdminCredentialsDAO.printAllData();
    }

    public static boolean authenticateUser(String username, String password) {
        if (AdminCred.containsKey(username)) {
            String storedPassword = AdminCred.get(username);
            return storedPassword.equals(password);
        }
        return false; // User does not exist
    }
    public static boolean userExists(String username) {
        return AdminCred.containsKey(username);
    }

//    Functions needed to be implemented --------------------------------------\\

//    public List<GymOwner> getAllOwners(){}
//    public void removeGymOwner(String userName);
//    public void removeGym(String ownerUserName, String gymCenterID);
//    public boolean approveGym(String ownerUserName, String gymCenterID);
//    public boolean approveGymOwner(String userName);

}