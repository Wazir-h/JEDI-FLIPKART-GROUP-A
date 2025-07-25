package com.flipfit.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymOwner;
import com.flipfit.constant.SqlQueries;


public class GymOwnerDAO {


    public static Map<String, GymOwner> OwnerCredentials = new HashMap<>();
    public static Map<String, List<GymCentre>> GymCenterDetails = new HashMap<>();


    static{
        try{
            Connection db = DBConnection.getConnection();
            PreparedStatement gymownerData = db.prepareStatement(SqlQueries.FETCH_ALL_GYMOWNERS);
            ResultSet resultSet = gymownerData.executeQuery();

            while (resultSet.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setUserId(resultSet.getString("user_id"));
                gymOwner.setUserName(resultSet.getString("user_name"));
                gymOwner.setUserEmail(resultSet.getString("user_email"));
                gymOwner.setGymOwnerAddress(resultSet.getString("user_address"));
                gymOwner.setGymOwnerPhone(resultSet.getString("user_phone"));
                gymOwner.setGSTNumber(resultSet.getString("gst_number"));
                gymOwner.setApproved(resultSet.getBoolean("is_approved"));

                OwnerCredentials.put(resultSet.getString("user_email"), gymOwner);
            }

            PreparedStatement gymCenterData = db.prepareStatement(SqlQueries.FETCH_ALL_GYM_CENTERS);
            resultSet = gymCenterData.executeQuery();
            while (resultSet.next()) {
                GymCentre gymCenter = new GymCentre();
                gymCenter.setGymID(resultSet.getString("gym_id"));
                gymCenter.setGymName(resultSet.getString("gym_name"));
                gymCenter.setGymCenterAddress(resultSet.getString("gym_center_address"));
                gymCenter.setGymCenterPhone(resultSet.getString("gym_center_phone"));
                gymCenter.setSlotCount(resultSet.getInt("slot_count"));
                gymCenter.setApproved(resultSet.getBoolean("is_approved"));
                String ownerEmail = resultSet.getString("owner_user_id");
                gymCenter.setUserName(ownerEmail);
                if (!GymCenterDetails.containsKey(ownerEmail)) {
                    List<GymCentre> gymsInCity = new ArrayList<>();
                    gymsInCity.add(gymCenter);
                    GymCenterDetails.put(ownerEmail, gymsInCity);
                } else {
                    GymCenterDetails.get(ownerEmail).add(gymCenter);
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void AddGymOwner(String username, GymOwner owner) {
        OwnerCredentials.put(username, owner);
        try{
            Connection db = DBConnection.getConnection();
            PreparedStatement gymownerRegistration = db.prepareStatement(SqlQueries.REGISTER_NEW_GYMOWNER_DETAILS);
            gymownerRegistration.setString(1, owner.getUserId());
            gymownerRegistration.setString(2, owner.getGymOwnerAddress());
            gymownerRegistration.setString(3, owner.getGymOwnerPhone());
            gymownerRegistration.setString(4, owner.getGSTNumber());
            gymownerRegistration.setBoolean(5, owner.isApproved());
            int rowsAffected = gymownerRegistration.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public static void AddGymCenter(String ownerEmail, GymCentre gymCenter) {

        if (!GymCenterDetails.containsKey(ownerEmail)) {
            List<GymCentre> gymsInCity = new ArrayList<>();
            gymsInCity.add(gymCenter);
            GymCenterDetails.put(ownerEmail, gymsInCity);
        } else {
            GymCenterDetails.get(ownerEmail).add(gymCenter);
        }

        try{
            Connection db = DBConnection.getConnection();
            PreparedStatement gymCenterRegistration = db.prepareStatement(SqlQueries.INSERT_GYM);
            gymCenterRegistration.setString(1, gymCenter.getGymID());
            gymCenterRegistration.setString(2, gymCenter.getGymName());
            gymCenterRegistration.setString(3, gymCenter.getGymCenterAddress());
            gymCenterRegistration.setString(4, gymCenter.getGymCenterPhone());
            gymCenterRegistration.setInt(5, gymCenter.getSlotCount());
            gymCenterRegistration.setBoolean(5, gymCenter.isApproved());
            gymCenterRegistration.setString(6, gymCenter.getUserEmail());
            int rowsAffected = gymCenterRegistration.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");

        }catch (SQLException e){
            System.out.println(e.getMessage());
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
        System.out.println("-".repeat(50));
        System.out.printf("%-30s %-40s %-15s %-50s %-15s%n", "Gym Name", "Gym Address", "Slots", "Gym ID", "Approved Status");
        System.out.println("-".repeat(50));
        for (GymCentre gymCentre : GymCenterDetails.get(userName)){
            System.out.println(gymCentre);
//            System.out.println(gymCentre);
        }
    }
    public static void getAllGyms(){
        if(GymCenterDetails.isEmpty()){
            System.out.println("No Gym is registered");
        }
        else{
            System.out.println("-".repeat(50));
            System.out.printf("%-30s %-40s %-15s %-50s %-15s%n", "Gym Name", "Gym Address", "Slots", "Gym ID", "Gym Status");
            System.out.println("-".repeat(50));
            for (List<GymCentre> gymlist: GymCenterDetails.values()){
                for(GymCentre gym: gymlist){
                    System.out.println(gym);
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
            System.out.println("-".repeat(130));
            System.out.printf("%-30s %-40s %-15s %-50s %-15s%n", "Gym Name", "Gym Address", "Slots", "Gym ID", "Gym Status");
            System.out.println("-".repeat(130));
            for (String ownerEmail : GymCenterDetails.keySet()) {
                List<GymCentre> gymsInCity = GymCenterDetails.get(ownerEmail);
                for (GymCentre gyms : gymsInCity) {
                    if (gyms.isApproved()) {
                        System.out.println(gyms);
                    }
                }
            }
            return;
        }
        List<GymCentre> gymsInCity = GymCenterDetails.get(gymusername);
        for (GymCentre gyms : gymsInCity) {
            if (gyms.isApproved()) {
                System.out.println(gyms);
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
                    System.out.println(gym);
                }
            }}
    }

    public static boolean userExists(String username) {
        return OwnerCredentials.containsKey(username);
    }

}