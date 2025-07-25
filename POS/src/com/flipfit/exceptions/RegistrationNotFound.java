package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "RegistrationNotFound"
 * @Description: "Custom exception class indicating that a specific registration record could not be found.
 * This exception is typically thrown when an attempt is made to retrieve, modify, or
 * interact with a user registration (e.g., a gym member's account or a booking registration)
 * that does not exist in the system. It provides a user-friendly message to signify
 * the absence of the queried registration."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception"
 *
 *
 */

public class RegistrationNotFound extends Exception {
    public String getMessage(){
        return "Oops! Registration Not Found.";
    }
}
