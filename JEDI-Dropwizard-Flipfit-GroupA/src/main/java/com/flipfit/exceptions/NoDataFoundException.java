package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "NoDataFoundException"
 * @Description: "Custom exception class to indicate that no data was found for a particular query or operation.
 * This exception is typically thrown when a database query or data retrieval process
 * yields an empty result set, contrary to the expectation of finding relevant data.
 * It provides a clear signal that the requested information does not exist or could not be retrieved."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception"
 *
 *
 */

public class NoDataFoundException extends Exception {
    public String getMessage(){
        return "No data was found";
    }
}
