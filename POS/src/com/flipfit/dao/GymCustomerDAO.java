package com.flipfit.dao;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import com.flipfit.beans.GymCustomer;
import com.flipfit.beans.Slot;

public class GymCustomerDAO  {
    public static Map<String, GymCustomer> CustomerCred = new HashMap<>();
    public static Map<String, List<Slot>> userBookings = new HashMap<>();
    public static Map<String, List<Integer>> GymBookings = new HashMap<>();

    public static void addCustomer(String username, GymCustomer customer) {
        CustomerCred.put(username, customer);
        System.out.println("Added customer: " + username );
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
        if (CustomerCred.containsKey(username)) {
            String storedPassword = CustomerCred.get(username).getUserPassword();
            return storedPassword.equals(password);
        }
        System.out.println("User Not exist");
        return false;
    }
    public static boolean updateCustomerProfile(String oldUsername, GymCustomer updatedCustomer) {
        if (!CustomerCred.containsKey(oldUsername)) {
            System.out.println("Error: Customer with username '" + oldUsername + "' not found. Profile update failed.");
            return false;
        }

        String newUsername = updatedCustomer.getUserName();

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
    public static boolean userExists(String username) {
        return CustomerCred.containsKey(username);
    }

    public static void bookSlot(String userName) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Book a Slot ---");
        System.out.print("Enter Gym ID: ");
        String gymId = sc.nextLine();

        System.out.print("Enter Start Time (1-12): ");
        int startTime = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter End Time (1-12): ");
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
        System.out.println("Start Time: " + newSlot.getSlotTimeStart());
        System.out.println("End Time: " + newSlot.getSlotTimeEnd());
        System.out.println("Slot booking process completed (details printed above).");
    }

}