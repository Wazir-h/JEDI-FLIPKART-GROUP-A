package com.flipfit.business;

import com.flipfit.business.GymBookingServiceInterface;

import java.sql.Timestamp;
import java.util.Date;
/*
 * @Author : "Kartik Aggarwal, Sujal Mishra, Abdul Razique"
 * @ClassName: "GymBookingService"
 * @Description: "Business Service layer for managing gym slot bookings within the FlipFit application.
 * This class implements the GymBookingServiceInterface and encapsulates
 * business logic for booking functionalities, such as retrieving current date/time,
 * and managing gym center details for booking purposes."
 * @Exceptions: "No specific custom exceptions defined yet, but could include BookingException"
 * @Version : "1.0"
 * @See : "com.flipfit.beans.Slot, com.flipfit.dao.GymOwnerDAO, com.flipfit.business.GymBookingServiceInterface"
 *
 *
 */
public class GymBookingService implements GymBookingServiceInterface {
    public Timestamp getDate() {
        return new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public String getGymCenter() {
        String gymCenterDetails = "";
        return gymCenterDetails;
    }
}