package com.flipfit.exceptions;

public class DataEntryException extends Exception {
    public String getMessage(){
        return "You have entered incorrect Data! Please provide correct input data.";
    }
}
