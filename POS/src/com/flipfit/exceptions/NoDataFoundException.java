package com.flipfit.exceptions;

public class NoDataFoundException extends Exception {
    public String getMessage(){
        return "No data was found";
    }
}
