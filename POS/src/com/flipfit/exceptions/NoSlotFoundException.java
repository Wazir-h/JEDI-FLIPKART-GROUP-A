package com.flipfit.exceptions;

public class NoSlotFoundException extends  Exception {
    public String getMessage() {
        return "No slots found!";
    }
}
