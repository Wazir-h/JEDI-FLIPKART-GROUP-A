package com.flipfit.exceptions;

public class RegistrationNotFound extends Exception {
    public String getMessage(){
        return "Oops! Registration Not Found.";
    }
}
