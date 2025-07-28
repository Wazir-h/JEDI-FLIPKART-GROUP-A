package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "DataEntryException"
 * @Description: "Custom exception class for handling incorrect data entry by the user.
 * This exception is thrown when user input does not conform to expected formats or values,
 * indicating a data validation failure. It provides a specific error message to guide the user."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception"
 *
 *
 */

public class DataEntryException extends Exception {
    public String getMessage(){
        return "You have entered incorrect Data! Please provide correct input data.";
    }
}
