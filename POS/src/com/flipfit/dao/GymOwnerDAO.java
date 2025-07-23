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
            List<GymCentre> gymsInCity = new ArrayList<>();
            gymsInCity.add(gymCenter);
            GymCenterDetails.put(ownerEmail, gymsInCity);
        } else {
            GymCenterDetails.get(ownerEmail).add(gymCenter);
        }
    }
    public static void DeleteGymCenter(String ownerEmail, String gymName) {
        List<GymCentre> gymsInCity = GymCenterDetails.get(ownerEmail);
        for (GymCentre gymCentre : gymsInCity) {
            if (gymCentre.getGymName().equals(gymName)) {
                gymsInCity.remove(gymCentre);
                break;
            }
        }

    }
    public static GymCentre GetGymCenter(String ownerEmail, String gymName) {
        List<GymCentre> gymsInCity = GymCenterDetails.get(ownerEmail);
        for (GymCentre gymCentre : gymsInCity) {
            if (gymCentre.getGymName().equals(gymName)) {
                return gymCentre;
            }
        }
        return null;
    }
    public static void getAllGymCenters(String userName){
        System.out.println("Gym Centres: ");
        for (GymCentre gymCentre : GymCenterDetails.get(userName)){
            System.out.println(gymCentre);
        }
    }
    public static void getAllGyms(){
        if(GymCenterDetails.isEmpty()){
            System.out.println("No Gym is registered");
        }
        else{
            for (List<GymCentre> gymlist: GymCenterDetails.values()){
                for(GymCentre gym: gymlist){
                    System.out.println(gym);
                }
            }
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