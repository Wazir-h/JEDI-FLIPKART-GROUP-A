package com.flipfit.exceptions;

public class GymOwnerNotFoundException extends Exception {
    public String getMessage(){
        return "Gym Owner Not Found";
    }
}
