package com.flipfit.beans;

public class Slot extends GymCenter, GymPayment {
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

}