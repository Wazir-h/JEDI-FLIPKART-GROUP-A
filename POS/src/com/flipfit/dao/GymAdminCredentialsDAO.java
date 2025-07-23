package com.flipfit.dao;
import java.util.HashMap;
import java.util.Map;
public class GymAdminCredentialsDAO {
    public static Map<String, String> AdminCred = new HashMap<>();

    // A method to add data to the shared HashMap
    public static void addData(String key, String value) {
        AdminCred.put(key, value);
//        System.out.println("Added: " + key + " -> " + value);
    }

    // A method to retrieve data from the shared HashMap
    public static String getData(String key) {
        return AdminCred.get(key);
    }

    // A method to print all data in the shared HashMap
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
            // In a real application, you would compare hashed passwords using a secure method like BCrypt.
            // For this example, we're doing a direct string comparison.
            return storedPassword.equals(password);
        }
        return false; // User does not exist
    }
    public static boolean userExists(String username) {
        return AdminCred.containsKey(username);
    }
}