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
//        System.out.println("Added Gym owner: " + username );
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

    public static void DeleteGymOwner(String ownerEmail) {
        if(!OwnerCredentials.containsKey(ownerEmail)){
            System.out.println("Gym owner not found");
            return;
        }
        OwnerCredentials.remove(ownerEmail);

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
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-30s %-40s %-15s %-15s %-15s%n", "Gym Name", "Gym Address", "Slots", "Gym ID");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (GymCentre gymCentre : GymCenterDetails.get(userName)){
            System.out.printf("%-30s %-40s %-15d %-15s %-15s%n ",
                    gymCentre.getGymName(),
                    gymCentre.getGymCenterAddress(),
                    gymCentre.getSlotCount(),
                    gymCentre.getGymID(),
                    gymCentre.isApproved()?"Approved":"Not Approved"
            );
//            System.out.println(gymCentre);
        }
    }
    public static void getAllGyms(){
        if(GymCenterDetails.isEmpty()){
            System.out.println("No Gym is registered");
        }
        else{
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("%-30s %-40s %-15s %-15s %-15s%n", "Gym Name", "Gym Address", "Slots", "Gym ID", "Gym Status");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (List<GymCentre> gymlist: GymCenterDetails.values()){
                for(GymCentre gym: gymlist){
                    System.out.printf("%-30s %-40s %-15d %-15s %-15s%n ",
                            gym.getGymName(),
                            gym.getGymCenterAddress(),
                            gym.getSlotCount(),
                            gym.getGymID(),
                            gym.isApproved()?"Approved":"Not Approved"
                    );
                }
            }
        }
    }
    public static void approveGym(String username, String gymName){
        GymCentre gymCenter = GetGymCenter(username, gymName);
        gymCenter.setApproved(true);
        DeleteGymCenter(username, gymName);
        AddGymCenter(username, gymCenter);
    }
    public static void getAllGymOwners() {
        for(String ownerEmail : OwnerCredentials.keySet()) {
            GymOwner gymOwner = OwnerCredentials.get(ownerEmail);
            System.out.println(gymOwner);
        }
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
    public static void viewApprovedGyms(String gymusername){
        if(gymusername == null) {
            for (String ownerEmail : GymCenterDetails.keySet()) {
                List<GymCentre> gymsInCity = GymCenterDetails.get(ownerEmail);
                for (GymCentre gyms : gymsInCity) {
                    if (gyms.isApproved()) {
                        System.out.printf("%-30s %-40s %-15d %-15s %-15s%n ",
                                gym.getGymName(),
                                gym.getGymCenterAddress(),
                                gym.getSlotCount(),
                                gym.getGymID(),
                                gym.isApproved()?"Approved":"Not Approved"
                        );
                    }
                }
            }
            return;
        }
        List<GymCentre> gymsInCity = GymCenterDetails.get(gymusername);
        for (GymCentre gyms : gymsInCity) {
            if (gyms.isApproved()) {
                System.out.printf("%-30s %-40s %-15d %-15s %-15s%n ",
                        gym.getGymName(),
                        gym.getGymCenterAddress(),
                        gym.getSlotCount(),
                        gym.getGymID(),
                        gym.isApproved()?"Approved":"Not Approved"
                );
            }
        }
    }
    public static void viewPendingGymApprovals(){
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-40s %-40s %-15s %-40s %-15s%n", "Gym Name", "Gym Address", "Slots", "Gym ID", "Gym Status");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for(String ownerEmail : GymCenterDetails.keySet()){
            List<GymCentre> gymsInCity = GymCenterDetails.get(ownerEmail);
            for(GymCentre gym : gymsInCity){
                if(!gym.isApproved()){
                    System.out.printf("%-30s %-40s %-15d %-15s %-15s%n ",
                            gym.getGymName(),
                            gym.getGymCenterAddress(),
                            gym.getSlotCount(),
                            gym.getGymID(),
                            gym.isApproved()?"Approved":"Not Approved"
                    );
                }
            }}
    }

    public static boolean userExists(String username) {
        return OwnerCredentials.containsKey(username);
    }

}