package com.flipfit.business;

import com.flipfit.beans.GymCustomer;

public interface GymCustomerBusinessServiceInterface {

    public void updateProfile(GymCustomer gymCustomer);

    public String getRole();

    public void viewAllGyms();
}
