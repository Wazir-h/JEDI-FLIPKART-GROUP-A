package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "UserNotFoundException"
 * @Description: "Custom exception class to indicate that a user could not be found based on provided credentials or identifiers.
 * This exception is typically thrown during authentication or user lookup processes when the
 * username or other identifying information does not correspond to an existing user account.
 * It provides a specific message to inform the user about incorrect credentials or the absence of the user."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception, com.flipfit.beans.User"
 *
 *
 */
public class UserNotFoundException extends Exception {
    public String getMessage() {
        return "Oops! Wrong Credential. User Not Found";
    }
}
