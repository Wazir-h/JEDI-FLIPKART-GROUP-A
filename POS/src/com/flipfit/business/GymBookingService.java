package com.flipkart.business;

import java.sql.Timestamp;
import java.util.Date;

public class GymBookingService {
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