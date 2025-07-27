package com.flipfit.business;

import com.flipfit.business.GymRegistrationBusinessServiceInterface;

/*
 * @Author : "Abdul Razique, Yashvardhan Yadav, Kartik Aggarwal"
 * @ClassName: "GymRegistrationBusinessService"
 * @Description: "Business Service layer for managing user registration processes within the FlipFit application.
 * This class implements the GymRegistrationBusinessServiceInterface and encapsulates
 * business logic for registration functionalities, such as generating registration IDs,
 * determining user roles, and recording registration dates."
 * @Exceptions: "No specific custom exceptions defined yet, but could include RegistrationException"
 * @Version : "1.0"
 * @See : "com.flipfit.beans.GymCustomer, com.flipfit.dao.DBConnection, com.flipfit.business.GymRegistrationBusinessServiceInterface"
 *
 *
 */
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