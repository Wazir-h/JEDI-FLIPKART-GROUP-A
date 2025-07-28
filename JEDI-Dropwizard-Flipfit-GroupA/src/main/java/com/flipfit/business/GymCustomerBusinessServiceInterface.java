package com.flipfit.business;

import com.flipfit.beans.GymCustomer;

public interface GymCustomerBusinessServiceInterface {

    public void updateProfile(GymCustomer gymCustomer);

    public String getRole();

    public String viewAllGyms();
    public  void bookSlot(String userName);
    public  void cancelSlot(String userName);
    public void viewAllAvailableSlots();
    void viewAllBookings(String userName);
}
