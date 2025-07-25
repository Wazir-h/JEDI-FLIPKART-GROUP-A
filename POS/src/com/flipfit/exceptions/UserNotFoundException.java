package com.flipfit.exceptions;

public class UserNotFoundException extends Exception {
    public String getMessage() {
        return "Oops! Wrong Credential. User Not Found";
    }
}
