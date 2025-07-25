package com.flipfit.constant;

/*
 * @Author : "Yashvardhan Yadav, Trilekya"
 * @ClassName: "SqlQueries"
 * @Version : "1.0"
 *
 */

public class SqlQueries {
//    public static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit_db?useSSL=false&serverTimezone=UTC";
//    public static final String DB_USER = "root"; // Your MySQL username
//    public static final String DB_PASSWORD = "password"; // Your MySQL password


    public static final String DB_URL = "jdbc:mysql://localhost:3306/flipfit";

    public static final String DB_USER = "root"; // Your MySQL username

    public static final String DB_PASSWORD = "kartik@123"; // Your MySQL password

    public static final String AUTHENTICATE_USER = "SELECT user_id, user_name, user_email, role_id FROM User WHERE user_name = ? AND user_password = ? AND role_id = ?";


    public static final String FETCH_ALL_USERS_BY_ROLE = "SELECT user_id, user_name, user_email FROM User WHERE role_id = ?";

    public static final String FETCH_ROLE_BY_ID = "SELECT id, name, description FROM Role WHERE id = ?";

    public static final String FETCH_ROLE_BY_NAME = "SELECT id, name, description FROM Role WHERE name = ?";

    public static final String FETCH_ALL_ROLES = "SELECT id, name, description FROM Role";

    public static final String FETCH_ALL_APPROVED_GYMS = "SELECT gym_id, gym_name, gym_center_address, gym_center_phone, slot_count, is_approved, owner_user_id FROM GymCentre WHERE is_approved = TRUE";

    public static final String FETCH_ALL_SLOTS_OF_GYM = "SELECT slot_id, slot_date, slot_time_start, slot_time_end, gym_id FROM Slot WHERE gym_id = ?";


    public static final String INITIAL = "SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0";
    public static final String INSERT_GYM =
            "INSERT INTO GymCentre (gym_id, gym_name, gym_center_address, gym_center_phone, slot_count, is_approved, owner_user_id) VALUES (?, ?, ?, ?, ?, ?, ?)" ;
    public static final String DELETE_GYM_CENTRE= "DELETE FROM GymCentre WHERE gym_name = ?";
    public static final String DELETE_GYM_OWNER= "DELETE FROM GYMOWNER WHERE USER_ID = ?";
    public static final String FETCH_PENDING_GYM_CENTERS = "SELECT gym_id, gym_name, gym_center_address, gym_center_phone, slot_count, is_approved, owner_user_id FROM GymCentre WHERE is_approved = FALSE";


    public static final String FETCH_ALL_GYM_CENTERS = "SELECT gym_id, gym_name, gym_center_address, gym_center_phone, slot_count, is_approved, owner_user_id FROM GymCentre";

    public static final String APPROVE_GYM_CENTER = "UPDATE GymCentre SET is_approved = TRUE WHERE gym_id = ?";

    public static final String CHECK_GYMCENTER_APPROVAL = "SELECT gym_id FROM GymCentre WHERE gym_id = ? AND is_approved = TRUE";



    public static final String FETCH_ALL_GYMOWNERS = "SELECT go.user_id, u.user_name, u.user_email, u.user_password, go.gym_owner_address, go.gym_owner_phone, go.gst_number, go.is_approved FROM GymOwner go JOIN User u ON go.user_id = u.user_id";

    public static final String FETCH_GYMOWNER_DETAILS = "SELECT go.user_id, u.user_name, u.user_email, go.gym_owner_address, go.gym_owner_phone, go.gst_number, go.is_approved FROM GymOwner go JOIN User u ON go.user_id = u.user_id WHERE u.user_email = ?";

    public static final String FETCH_GYMOWNER_ALL_GYMS = "SELECT gc.gym_id, gc.gym_name, gc.gym_center_address, gc.gym_center_phone, gc.slot_count, gc.is_approved, gc.owner_user_id FROM GymCentre gc JOIN GymOwner go ON gc.owner_user_id = go.user_id JOIN User u ON go.user_id = u.user_id WHERE u.user_email = ?";

    public static final String FETCH_GYMOWNER_ALL_APPROVED_GYMS = "SELECT gc.gym_id, gc.gym_name, gc.gym_center_address, gc.gym_center_phone, gc.slot_count, gc.is_approved, gc.owner_user_id FROM GymCentre gc JOIN GymOwner go ON gc.owner_user_id = go.user_id JOIN User u ON go.user_id = u.user_id WHERE u.user_email = ? AND gc.is_approved = TRUE";

    public static final String CHECK_GYMOWNER_APPROVAL = "SELECT go.user_id FROM GymOwner go JOIN User u ON go.user_id = u.user_id WHERE u.user_email = ? AND go.is_approved = TRUE";

    public static final String FETCH_PENDING_OR_APPROVED_GYM_OWNERS = "SELECT go.user_id, u.user_name, u.user_email, go.gym_owner_address, go.gym_owner_phone, go.gst_number, go.is_approved FROM GymOwner go JOIN User u ON go.user_id = u.user_id WHERE go.is_approved = ?";

    public static final String APPROVE_GYM_OWNER = "UPDATE GymOwner SET is_approved = TRUE WHERE user_id = ?";



    public static final String INSERT_SLOT = "INSERT INTO Slot (gym_id, slot_date, slot_id, slot_time_end, slot_time_start) VALUES (?, ?, ?, ?, ?)";



    public static final String INSERT_BOOKING = "INSERT INTO GymBooking (slot_id, user_id, booking_time) VALUES (?, ?, ?)";

    public static final String FETCH_ALL_CUSTOMER_BOOKINGS = "SELECT gb.booking_id, gb.slot_id, gb.user_id, gb.booking_time, gb.is_active FROM GymBooking gb JOIN GymCustomer gc ON gb.user_id = gc.user_id JOIN User u ON gc.user_id = u.user_id WHERE u.user_email = ? AND gb.is_active = ?";

    public static final String CHECK_SLOT_ALREADY_BOOKED = "SELECT gb.booking_id FROM GymBooking gb JOIN User u ON gb.user_id = u.user_id WHERE gb.slot_id = ? AND u.user_email = ? AND DATE(gb.booking_time) = ?";

    public static final String CANCEL_BOOKING = "UPDATE GymBooking SET is_active = FALSE WHERE booking_id = ? AND user_id = (SELECT user_id FROM User WHERE user_email = ?)";



    public static final String REGISTER_NEW_USER = "INSERT INTO User (user_id, user_name, user_email, user_password, role_id) VALUES (?, ?, ?, ?, ?)";

    public static final String REGISTER_NEW_CUSTOMER_DETAILS = "INSERT INTO GymCustomer (user_id, address, phone_no) VALUES (?, ?, ?)";

    public static final String REGISTER_NEW_GYMOWNER_DETAILS = "INSERT INTO GymOwner (user_id, gym_owner_address, gym_owner_phone, gst_number, is_approved) VALUES (?, ?, ?, ?, ?)";

    public static final String MAKE_PAYMENT = "INSERT INTO GymPayment (payment_id, user_id, payment_time,amount,status,slot_time_start,slot_time_end,slot_date) VALUES (?, ?, CURRENT_TIMESTAMP(),?,?,?,?,?)";

    public static final String UPDATE_USER_DETAILS = "UPDATE User SET user_name = ?, user_email = ?, user_password = ? WHERE user_id = ?";

    public static final String UPDATE_GYM_CUSTOMER_DETAILS = "UPDATE GymCustomer SET address = ?, phone_no = ? WHERE user_id = ?";

    public static final String FETCH_ALL_GYM_CUSTOMERS_WITH_USER_DETAILS = "SELECT gc.user_id, u.user_name, u.user_email, gc.address, gc.phone_no " + "FROM GymCustomer gc " + "JOIN User u ON gc.user_id = u.user_id";

    public static final String SELECT_USER_BY_USERNAME = "SELECT user_id FROM User WHERE user_name = ?";

    public static final String GET_USER_BY_USERNAME = "SELECT u.user_id, u.user_name, u.user_email, u.user_password, u.role_id, gc.address, gc.phone_no " +
            "FROM User u LEFT JOIN GymCustomer gc ON u.user_id = gc.user_id " +
            "WHERE u.user_name = ?";
}