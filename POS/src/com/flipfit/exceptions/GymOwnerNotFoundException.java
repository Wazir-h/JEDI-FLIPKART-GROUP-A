package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "GymOwnerNotFoundException"
 * @Description: "Custom exception class to indicate that a requested gym owner could not be found within the system.
 * This exception is typically thrown when an attempt is made to access, modify, or interact with
 * a gym owner using credentials or identifiers that do not correspond to any existing owner.
 * It ensures proper error handling and informs the user about the absence of the specified gym owner."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception, com.flipfit.beans.GymOwner"
 *
 *
 */

public class GymOwnerNotFoundException extends Exception {
    public String getMessage(){
        return "Gym Owner Not Found";
    }
}
