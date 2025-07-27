package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Raziquem, Yashvardhan Yadav"
 * @ClassName: "GymNotFoundException"
 * @Description: "Custom exception class indicating that a requested gym or gym center could not be found.
 * This exception is typically thrown when an operation attempts to access or modify a gym
 * using an identifier that does not correspond to any existing gym in the system.
 * It provides a clear message to signify the absence of the queried gym."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception, com.flipfit.beans.GymCentre"
 *
 *
 */

public class GymNotFoundException extends Exception {
    public String getMessage(){
        return "Gym Not Found Exception";
    }
}
