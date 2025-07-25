package com.flipfit.dao;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import com.flipfit.beans.GymCustomer;
import com.flipfit.beans.Slot;
import com.flipfit.business.GymPaymentBusinessService;
import com.flipfit.constant.SqlQueries;

import static com.flipfit.dao.DBConnection.getConnection;

public class GymCustomerDAO  {
    public static Map<String, GymCustomer> CustomerCred = new HashMap<>();
    public static Map<String, List<Slot>> userBookings = new HashMap<>();
    public static Map<String, List<Integer>> GymBookings = new HashMap<>();

    public static void loadBookingDetails(String userName){
        String sql = "SELECT " +
                "S.slot_id, S.slot_date, S.slot_time_start, S.slot_time_end, S.gym_id " +
                "FROM Slot S " +
                "JOIN GymBooking GB ON S.slot_id = GB.slot_id " +
                "WHERE GB.user_id = ?";
        try {
            Connection db = getConnection();
            PreparedStatement ps1 = db.prepareStatement(sql);
            ps1.setString(1, userName); // Set the user_id parameter
            ResultSet rs = ps1.executeQuery();
            List<Slot> loadedSlots = new ArrayList<>();
            while (rs.next()) {
                Slot slot = new Slot();
                slot.setSlotID(rs.getString("slot_id"));
                slot.setSlotDate(rs.getDate("slot_date"));
                slot.setSlotTimeStart(rs.getTimestamp("slot_time_start"));
                slot.setSlotTimeEnd(rs.getTimestamp("slot_time_end"));
                loadedSlots.add(slot);
            }

            userBookings.put(userName, loadedSlots);
            System.out.println("DAO: Loaded " + loadedSlots.size() + " bookings for user '" + userName + "' from database.");

        } catch (SQLException e) {
            System.err.println("DAO Error: Failed to load booking details for user '" + userName + "' from MySQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Load Booking Slots Called");
        }
    }


    public static void addCustomer(String username, GymCustomer customer) {
        CustomerCred.put(username, customer);
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;

        try{
            Connection db = DBConnection.getConnection();
            PreparedStatement ps1 = db.prepareStatement(SqlQueries.REGISTER_NEW_USER);
            customer.setId(customer.getUserEmail());
            ps1.setString(1,customer.getId());
            ps1.setString(2,customer.getUserName());
            ps1.setString(3,customer.getUserEmail());
            ps1.setString(4,customer.getUserPassword());
            ps1.setString(5,"1");
            int rowsAffected = ps1.executeUpdate();
            ps2 = db.prepareStatement(SqlQueries.REGISTER_NEW_CUSTOMER_DETAILS);
            ps2.setString(1,customer.getId());
            ps2.setString(2,customer.getAddress());
            ps2.setString(3,customer.getPhoneNo());
            rowsAffected = ps2.executeUpdate();
            System.out.println("Rows Affected\t" + rowsAffected);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing PreparedStatement ps1: " + closeEx.getMessage());
                }
            }
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing PreparedStatement ps2: " + closeEx.getMessage());
                }
            }

//            System.out.println(e.getMessage());
        }
    }

    public static void getAllCustomers() {
        System.out.println("All customers: ");
    }
    public static GymCustomer getGymCustomerDetail(String username){
        if(CustomerCred.containsKey(username)){
            return CustomerCred.get(username);
        }
        return null;
    }
    public static boolean authenticateUser(String username, String password) {
        try{
            Connection db = DBConnection.getConnection();
            PreparedStatement ps1 = db.prepareStatement(SqlQueries.AUTHENTICATE_USER);
            ps1.setString(1,username);
            ps1.setString(2,password);
            try (ResultSet rs = ps1.executeQuery()) {
                if (rs.next()) {

                    System.out.println("User " + username + " authenticated successfully.");
                    return true;
                } else {

                    System.out.println("User Not exist or invalid credentials for " + username);
                    return false;
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean updateCustomerProfile(String oldUsername, GymCustomer updatedCustomer) {
        String userId=updatedCustomer.getUserId();
        String newUsername=updatedCustomer.getUserName();
        String newUserEmail=updatedCustomer.getUserEmail();
        String newUserPassword=updatedCustomer.getUserPassword();
        String newUserAddress=updatedCustomer.getAddress();
        String newUserPhoneNo=updatedCustomer.getPhoneNo();
        System.out.println(oldUsername);
        System.out.println(userId);
        System.out.println(newUsername);
        System.out.println(newUserEmail);
        System.out.println(newUserPassword);
        System.out.println(newUserAddress);
        System.out.println(newUserPhoneNo);
        Connection db = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try{
            db = DBConnection.getConnection();
            db.setAutoCommit(false);
            ps1 = db.prepareStatement(SqlQueries.UPDATE_USER_DETAILS);
            ps1.setString(1,newUsername);
            ps1.setString(2,newUserEmail);
            ps1.setString(3,newUserPassword);
            ps1.setString(4,userId);
            ps1.executeUpdate();
            ps2 = db.prepareStatement(SqlQueries.UPDATE_GYM_CUSTOMER_DETAILS);
            ps2.setString(1,newUserAddress);
            ps2.setString(2,newUserPhoneNo);
            ps2.setString(3,userId);
            ps2.executeUpdate();
            db.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing PreparedStatement ps1: " + closeEx.getMessage());
                }
            }
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing PreparedStatement ps2: " + closeEx.getMessage());
                }
            }
            if (db != null) {
                try {
                    db.close(); // Close the Connection
                } catch (SQLException closeEx) {
                    System.err.println("Error closing Connection: " + closeEx.getMessage());
                }
            }
        }

        if (!CustomerCred.containsKey(oldUsername)) {
            System.out.println("Error: Customer with username '" + oldUsername + "' not found. Profile update failed.");
            return false;
        }
        if (!oldUsername.equals(newUsername)) {

            if (CustomerCred.containsKey(newUsername)) {
                System.out.println("Error: New username '" + newUsername + "' is already taken by another user. Profile update failed.");
                return false;
            }

            CustomerCred.remove(oldUsername);
            System.out.println("Username for customer changed from '" + oldUsername + "' to '" + newUsername + "'.");
        }

        CustomerCred.put(newUsername, updatedCustomer);

        System.out.println("Profile for customer '" + newUsername + "' updated successfully.");
        System.out.println("New details: " + updatedCustomer);
        return true;
    }
    public static boolean userExists(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();

            ps = conn.prepareStatement(SqlQueries.SELECT_USER_BY_USERNAME);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("SQL Error checking user existence: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing PreparedStatement ps1: " + closeEx.getMessage());
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing ResultSet rs: " + closeEx.getMessage());
                }
            }

        }
        return false; // Default return if no user found or an error occurred
    }
    public static void bookSlot(String userName) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Book a Slot ---");
        System.out.print("Enter Gym Name: ");
        String gymId = sc.nextLine();

        System.out.print("Enter Start Time (6-8): ");
        int startTime = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter End Time (7-9): ");
        int endTime = sc.nextInt();
        sc.nextLine();
        System.out.print("For Shift enter E (Evening) or M (Morning): ");
        String shift = sc.nextLine().trim().toUpperCase(); // Read shift and normalize it
        if (startTime < 1 || startTime > 12 || endTime < 1 || endTime > 12) {
            System.out.println("Invalid time input. Start and End times must be between 1 and 12.");
            return;
        }
        if (!shift.equals("E") && !shift.equals("M")) {
            System.out.println("Invalid shift input. Please enter 'E' for Evening or 'M' for Morning.");
            return;
        }
        // --- Calculate Start Time Timestamp ---
        LocalDate today = LocalDate.now(); // Get today's date
        int startHour24 = startTime; // Initialize with 12-hour format
        if (shift.equals("E") && startTime != 12) { // If Evening and not 12 PM (noon)
            startHour24 = startTime + 12;
        } else if (shift.equals("M") && startTime == 12) { // If Morning and 12 AM (midnight)
            startHour24 = 0; // 12 AM is 00:00 in 24-hour format
        }
        LocalTime localStartTime = LocalTime.of(startHour24, 0); // Assuming minutes are 00
        LocalDateTime startDateTime = LocalDateTime.of(today, localStartTime);
        Timestamp slotTimeStart = Timestamp.valueOf(startDateTime);
        // --- Calculate End Time Timestamp ---
        int endHour24 = endTime;
        if (shift.equals("E") && endTime != 12) {
            endHour24 = endTime + 12;
        } else if (shift.equals("M") && endTime == 12) {
            endHour24 = 0;
        }
        LocalTime localEndTime = LocalTime.of(endHour24, 0);
        LocalDateTime endDateTime = LocalDateTime.of(today, localEndTime);
        Timestamp slotTimeEnd = Timestamp.valueOf(endDateTime);
        // --- Create and Set Slot Details ---
        Slot newSlot = new Slot();
        newSlot.setSlotID(gymId + "_" + userName + "_" + slotTimeStart.getTime()); // Using timestamp long value for uniqueness
        newSlot.setSlotTimeStart(slotTimeStart);
        newSlot.setSlotTimeEnd(slotTimeEnd);
        newSlot.setGymName(gymId);
        System.out.println(GymBookings);
        if(shift.equals("M") && GymBookings.get(gymId).get(startTime-6) >0){
            GymBookings.get(gymId).set(startTime-6,GymBookings.get(gymId).get(startTime-6)-1);
        }else if(shift.equals("E") && GymBookings.get(gymId).get(startTime-3) > 0){
            GymBookings.get(gymId).set(startTime-3,GymBookings.get(gymId).get(startTime-3)-1);
        }else{
            System.out.println("Slots not available in this time");
            return;
        }
        PreparedStatement ps1=null;
        try {
            Connection db = getConnection();
            db.setAutoCommit(false); // Start transaction for DB operations

            ps1 = db.prepareStatement(SqlQueries.INSERT_SLOT);
            ps1.setString(1, newSlot.getSlotID()); // Use the generated slot ID
            ps1.setDate(2, java.sql.Date.valueOf(newSlot.getSlotTimeStart().toLocalDateTime().toLocalDate())); // Extract date
            ps1.setTimestamp(3, newSlot.getSlotTimeStart());
            ps1.setTimestamp(4, newSlot.getSlotTimeEnd());
            ps1.setString(5, gymId);

            int rowsAffected1 = ps1.executeUpdate();
            if (rowsAffected1 == 0) {
                throw new SQLException("Booking slot failed, no rows affected in Slot table.");
            }
            PreparedStatement ps2 = db.prepareStatement(SqlQueries.INSERT_BOOKING);
            ps2.setString(1,newSlot.getSlotID());
            ps2.setString(2,newSlot.getUserId());
            ps2.setTimestamp(3,newSlot.getSlotTimeStart());
            int rowsAffected2 = ps2.executeUpdate();
            if (rowsAffected2 == 0) {
                throw new SQLException("Booking slot failed, no rows affected in Booking table.");
            }
            db.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(ps1!=null){
                try{
                    ps1.close();
                }
                catch (SQLException closeEx) {
                    System.err.println("Error closing PreparedStatement ps1: " + closeEx.getMessage());
                }

            }
        }
        if(userBookings.containsKey(userName)){
            userBookings.get(userName).add(newSlot);
        }else {
            List<Slot> slots = new ArrayList<>();
            slots.add(newSlot);
            userBookings.put(userName, slots);
        }
        System.out.println("\nSlot booking details:");
        System.out.println("Gym ID: " + gymId);
        System.out.println("Customer: " + userName);
        System.out.println("Booked Slot: " + newSlot.getSlotID());
        System.out.println("Start Time: " + startTime + newSlot.getSlotTimeStart());
        System.out.println("End Time: " + endTime + newSlot.getSlotTimeEnd());
        System.out.println("Slot booking process completed (details printed above).");
        GymPaymentBusinessService.makePayment(userName, 100, startTime, endTime);
    }

    public static void fillNumberofSlotInGym(String gymId, int mxSlot){
        List<Integer> numberOfSlots = new ArrayList<>();
        for(int i=0;i<6;i++) numberOfSlots.add(mxSlot);
        GymBookings.put(gymId,numberOfSlots);
    }

    public static void cancelBooking(String userName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Cancel a Slot ---");
        System.out.print("Enter Gym ID of the slot to cancel: ");
        String gymId = sc.nextLine();

        System.out.print("Enter Start Time (6-8) of your slot: ");
        int startTime = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter End Time (7-9) of your slot: ");
        int endTime = sc.nextInt();
        sc.nextLine();

        System.out.print("For Shift enter E (Evening) or M (Morning) of your slot: ");
        String shift = sc.nextLine().trim().toUpperCase();

        if (startTime < 1 || startTime > 12 || endTime < 1 || endTime > 12) {
            System.out.println("Invalid time input. Start and End times must be between 1 and 12.");
            return;
        }
        if (!shift.equals("E") && !shift.equals("M")) {
            System.out.println("Invalid shift input. Please enter 'E' for Evening or 'M' for Morning.");
            return;
        }
        // --- Calculate Timestamp for the slot to be cancelled ---
        LocalDate today = LocalDate.now();
        int startHour24 = startTime;
        if (shift.equals("E") && startTime != 12) {
            startHour24 = startTime + 12;
        } else if (shift.equals("M") && startTime == 12) {
            startHour24 = 0;
        }
        LocalTime localStartTime = LocalTime.of(startHour24, 0);
        LocalDateTime startDateTime = LocalDateTime.of(today, localStartTime);
        Timestamp slotTimeStart = Timestamp.valueOf(startDateTime);

        int endHour24 = endTime;
        if (shift.equals("E") && endTime != 12) {
            endHour24 = endTime + 12;
        } else if (shift.equals("M") && endTime == 12) {
            endHour24 = 0;
        }
        LocalTime localEndTime = LocalTime.of(endHour24, 0);
        LocalDateTime endDateTime = LocalDateTime.of(today, localEndTime);
        Timestamp slotTimeEnd = Timestamp.valueOf(endDateTime);
        // --- Find and Remove Slot from userBookings ---
        if (!userBookings.containsKey(userName)) {
            System.out.println("You have no bookings to cancel.");
            return;
        }
        List<Slot> userSlots = userBookings.get(userName);
        Slot slotToCancel = null;
        int foundIndex = -1;

        // Iterate to find the exact slot to cancel
        for (int i = 0; i < userSlots.size(); i++) {
            Slot s = userSlots.get(i);
            if (s.getSlotTimeStart().equals(slotTimeStart) &&
                    s.getSlotTimeEnd().equals(slotTimeEnd) &&
                    s.getSlotID().startsWith(gymId + "_" + userName)) {
                slotToCancel = s;
                foundIndex = i;
                break;
            }
        }
        if (slotToCancel != null) {
            userSlots.remove(foundIndex);
            System.out.println("DAO: Slot " + slotToCancel.getSlotID() + " cancelled for user " + userName + ".");
            // --- Update GymBookings (Increment Slot Count) ---
            int slotIndex = -1;
            if (shift.equals("M")) {
                if (startTime >= 6 && startTime <= 11) {
                    slotIndex = startTime - 6;
                }
            } else if (shift.equals("E")) {
                if (startTime >= 3 && startTime >= 3 && startTime <= 8) { // Corrected range for evening
                    slotIndex = startTime - 3;
                }
            }
            if (slotIndex != -1 && GymBookings.containsKey(gymId) && GymBookings.get(gymId) != null && slotIndex < GymBookings.get(gymId).size()) {
                List<Integer> gymSlots = GymBookings.get(gymId);
                gymSlots.set(slotIndex, gymSlots.get(slotIndex) + 1); // Increment available slot
                System.out.println("DAO: Slot count for Gym " + gymId + " at " + startTime + shift + " increased to " + gymSlots.get(slotIndex));
            } else {
                System.out.println("DAO Warning: Could not update gym slot availability (gym ID or slot index invalid).");
            }

            System.out.println("Slot cancellation process completed successfully.");
        } else {
            System.out.println("No matching slot found for cancellation with the provided details.");
        }
    }

    public static void viewBookings(String userName){
        for(Slot slot: userBookings.get(userName)){
            System.out.println(slot);
        }
    }


}