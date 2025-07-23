package com.flipfit.helper;
import java.util.HashMap;
import java.util.Map;
import com.flipfit.beans.GymOwner;

public class GymOwnerCredentials {


    public static Map<String, GymOwner> OwnerCredentials = new HashMap<>();

    public static void addGymOwner(String username, GymOwner owner) {
        OwnerCredentials.put(username, owner);
        System.out.println("Added Gym owenr: " + username );
    }

    public static void getAllOwners() {
        System.out.println("All owners: ");
    }

    public static GymOwner getGymOwnerDetail(String username){
        if(OwnerCredentials.containsKey(username)){
            return OwnerCredentials.get(username);
        }
        return null;
    }
    public static boolean authenticateUser(String username, String password) {
        if (OwnerCredentials.containsKey(username)) {
            String storedPassword = OwnerCredentials.get(username).getUserPassword();
            return storedPassword.equals(password);
        }
        return false;
    }

    public static boolean userExists(String username) {
        return OwnerCredentials.containsKey(username);
    }

}