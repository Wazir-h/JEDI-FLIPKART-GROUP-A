package com.flipfit.dao;
import java.util.HashMap;
import java.util.Map;
import com.flipfit.beans.GymCustomer;

public class GymCustomerDAO implements  {
    public static Map<String, GymCustomer> CustomerCred = new HashMap<>();

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

}