package com.flipkart.business;

import com.flipfit.business.RegistrationBusinessServiceInterface;

public class RegistrationBusinessService implements RegistrationBusinessServiceInterface {
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