package com.flipfit.exceptions;

public class GymNotFoundException extends Exception {
    public String getMessage(){
        return "Gym Not Found Exception";
    }
}
