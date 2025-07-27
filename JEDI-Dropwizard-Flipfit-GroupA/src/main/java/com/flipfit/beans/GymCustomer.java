package com.flipfit.beans;

/*
 * @Author : "Abdul Razique"
 * @ClassName: "GymCustomer"
 * @Version : "1.0"
 */
public class GymCustomer extends User {

    private String address;
    private String phoneNo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
