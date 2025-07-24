package com.flipfit.dao;

import com.flipfit.beans.GymCustomer;

public interface GymCustomerDAOInterface {
    public void addCustomer(String username, GymCustomer customer);
    public void getAllCustomers();
    public GymCustomer getGymCustomerDetail(String username);
    public boolean authenticateUser(String username, String password) ;
    public boolean updateCustomerProfile(String oldUsername, GymCustomer updatedCustomer) ;
    public boolean userExists(String username);

}
