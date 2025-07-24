package com.flipfit.beans;
import java.sql.Timestamp;
import java.util.Date;
public class Slot extends GymCentre {
    private Timestamp slotbookingTime;
    private Timestamp SlotTimeStart;
    private Timestamp SlotTimeEnd;
    private String SlotID;

    public Timestamp getSlotbookingTime() {
        return slotbookingTime;
    }

    public void setSlotbookingTime(Timestamp slotbookingTime) {
        this.slotbookingTime = slotbookingTime;
    }

    public Timestamp getSlotTimeStart() {
        return SlotTimeStart;
    }

    public void setSlotTimeStart(Timestamp slotTimeStart) {
        SlotTimeStart = slotTimeStart;
    }


    public Timestamp getSlotTimeEnd() {
        return SlotTimeEnd;
    }

    public void setSlotTimeEnd(Timestamp slotTimeEnd) {
        SlotTimeEnd = slotTimeEnd;
    }

    public String getSlotID() {
        return SlotID;
    }

    public void setSlotID(String slotID) {
        SlotID = slotID;
    }

    public Date getSlotDate() {
        return SlotDate;
    }

    public void setSlotDate(Date slotDate) {
        SlotDate = slotDate;
    }

    private Date SlotDate;

    @Override
    public String toString() {
        return String.format(
        """
        Slot Id: %s,
        Slot Starting Time: %s,
        Slot Ending Time: %s,
        Gym Name: %s,
        """,
                getSlotID(),
                getSlotTimeStart(),
                getSlotTimeEnd(),
                getGymName());
    }

}