package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "NullException"
 * @Description: "Custom exception class to signify that a null or uninitialized data value was encountered where a valid object or data was expected.
 * This exception is typically thrown to prevent NullPointerExceptions and to provide a more descriptive
 * error message when an essential piece of data is missing or invalid (specifically null).
 * It helps in clearly identifying situations where data integrity is compromised due to null values."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception, java.lang.NullPointerException"
 *
 *
 */

public class NullException extends  Exception {
    public String getMessage(){
        return "Null Data Found";
    }
}
