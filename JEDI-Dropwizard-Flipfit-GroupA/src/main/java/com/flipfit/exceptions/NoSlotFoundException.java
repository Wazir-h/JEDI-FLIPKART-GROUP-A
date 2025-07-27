package com.flipfit.exceptions;

/*
 * @Author : "Kartik Aggarwal, Shivansh Sinha, Sujal Mishra, Abdul Razique, Yashvardhan Yadav"
 * @ClassName: "NoSlotFoundException"
 * @Description: "Custom exception class to indicate that no available time slots were found for a given query or criteria.
 * This exception is typically thrown in scenarios where a user or system component
 * is searching for booking slots (e.g., for a gym session), but no suitable slots
 * are currently open or match the specified requirements. It provides a clear message
 * to inform that no appointments or timeframes are available."
 * @Exceptions: "None - This is a custom exception inheriting from java.lang.Exception."
 * @Version : "1.0"
 * @See : "java.lang.Exception, com.flipfit.beans.Slot"
 *
 *
 */


public class NoSlotFoundException extends  Exception {
    public String getMessage() {
        return "No slots found!";
    }
}
