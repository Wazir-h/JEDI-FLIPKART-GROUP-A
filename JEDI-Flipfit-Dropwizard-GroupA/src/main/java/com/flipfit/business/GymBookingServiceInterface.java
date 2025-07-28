package com.flipfit.business;

import java.sql.Timestamp;

public interface GymBookingServiceInterface {
    public Timestamp getDate();

    public Timestamp getTime();

    public String getGymCenter();
}
