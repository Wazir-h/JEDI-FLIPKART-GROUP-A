package com.flipfit.business;

import com.flipfit.business.GymBookingServiceInterface;

import java.sql.Timestamp;
import java.util.Date;

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