package com.flipfit.beans;


/*
 * @Author : "Sujal Mishra"
 * @ClassName: "Registration"
 * @Version : "1.0"
 */
public class Registration extends User{
    private int registrationId;
    private int dateOfRegistration;
    private boolean isRegistered;
    private String userRole;

    private int getRegistrationId(){
        return registrationId;
    }
    private void setRegistrationId(int registrationId){
        this.registrationId=registrationId;
    }
    private int getDateOfRegistration(){
        return dateOfRegistration;
    }
    private void setDateOfRegistration(int dateOfRegistration){
        this.dateOfRegistration=dateOfRegistration;
    }
    private boolean getIsRegistered(){ return true;
    }
    private void setRegistered(boolean isRegistered){
        this.isRegistered=isRegistered;
    }
}