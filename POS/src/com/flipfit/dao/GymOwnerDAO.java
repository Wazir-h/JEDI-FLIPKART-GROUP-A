package com.flipfit.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;

public class GymOwnerDAO {


    public static Map<String, GymOwner> OwnerCredentials = new HashMap<>();
    public static Map<String, List<GymCentre>> GymCenterDetails = new HashMap<>();

    public static void AddGymOwner(String username, GymOwner owner) {
        OwnerCredentials.put(username, owner);
        System.out.println("Added Gym owner: " + username );
    }
    public static void AddGymCenter(String ownerEmail, GymCentre gymCenter) {

        if (!GymCenterDetails.containsKey(ownerEmail)) {
            // If not, create a new list, add the gym, and put it in the map
            List<GymCentre> gymsInCity = new ArrayList<>();
            gymsInCity.add(gymCenter);
            GymCenterDetails.put(ownerEmail, gymsInCity);
        } else {
            // If the city already exists, get the list and add the new gym to it
            GymCenterDetails.get(ownerEmail).add(gymCenter);
        }
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