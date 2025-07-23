package com.flipfit.helper;
import java.util.HashMap;
import java.util.Map;
import com.flipfit.beans.GymCustomer;

public class GymCustomerCredentials {
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

    public static boolean userExists(String username) {
        return CustomerCred.containsKey(username);
    }

}