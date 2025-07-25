package com.flipfit.business;

import com.flipfit.business.GymRegistrationBusinessServiceInterface;

public class GymRegistrationBusinessService implements GymRegistrationBusinessServiceInterface {
    public void getRegistrationID(){
        System.out.println("This is Registration ID: ");
    }
    public void getRole(){
        System.out.println("Role of User: ");
    }

    public void getDateofRegistration(){
        System.out.println("Date of Registration: ");
    }
}