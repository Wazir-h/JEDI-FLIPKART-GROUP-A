package com.flipfit.rest;

import com.flipfit.beans.GymCentre;
import com.flipfit.beans.GymCustomer;
import com.flipfit.beans.GymOwner;
import com.flipfit.beans.Slot;
import com.flipfit.business.GymCustomerBusinessService;
import com.flipfit.business.GymCustomerBusinessServiceInterface;
import com.flipfit.business.GymOwnerBusinessService;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.dao.GymOwnerDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flipfit.dao.GymCustomerDAO.bookSlotApi;

// The base path for all endpoints in this class is now /gymservice
@Path("/gymservice")
public class GymServiceRest {

    // The HelloWorld test endpoints are kept as they were.
    @GET
    @Path("/get")
    public String HelloWorldGetService() {
        return "Hello World! Fetch Service";
    }
    @PUT
    @Path("/update")
    public String HelloWorldPutService() {
        return "Hello World! Update Service";
    }

    @DELETE
    @Path("/delete")
    public String HelloWorldDeleteService() {
        return "Hello World! Delete Service";
    }

    @POST
    @Path("/post")
    public String HelloWorldPostService() {
        return "Hello World! Post Service";
    }

    /**
     * Retrieves all approved gyms.
     * The path is now cleaner: GET /gymservice/gyms
     */
    @GET
    @Path("/gyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllGyms() {
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        String gymData = gymCustomerBusinessService.viewAllGyms();
        Map<String, String> jsonOutput = Collections.singletonMap("gyms", gymData);
        return Response.ok(jsonOutput).build();
    }


    /**
     * Authenticates a user based on email and password.
     * The path has been simplified.
     * To fix the "Not Found" error, send a POST request to: /gymservice/customer/login
     */
    @POST
    @Path("/customer/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(@FormParam("email") String email, @FormParam("password") String password) {
        // It's better practice to call the business service layer, not the DAO directly from the controller.
        // This is left as is from your original code, but consider moving the auth logic to the service.
        boolean isAuthenticated = GymCustomerDAO.authenticateUser(email, password);

        Map<String, String> jsonResponse = new HashMap<>();

        if (isAuthenticated) {
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "Login successful.");
            return Response.ok(jsonResponse).build();
        } else {
            jsonResponse.put("status", "error" + email + password);
            jsonResponse.put("message", "Invalid email or password.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(jsonResponse).build();
        }
    }
    @POST
    @Path("/admin/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAdmin(@FormParam("email") String email, @FormParam("password") String password) {
        // It's better practice to call the business service layer, not the DAO directly from the controller.
        // This is left as is from your original code, but consider moving the auth logic to the service.
        boolean isAuthenticated = GymAdminDAO.authenticateUser(email, password);

        Map<String, String> jsonResponse = new HashMap<>();

        if (isAuthenticated) {
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "Login successful.");
            return Response.ok(jsonResponse).build();
        } else {
            jsonResponse.put("status", "error" + email + password);
            jsonResponse.put("message", "Invalid email or password.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(jsonResponse).build();
        }
    }
    @POST
    @Path("/owner/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginOwner(@FormParam("email") String email, @FormParam("password") String password) {
        // It's better practice to call the business service layer, not the DAO directly from the controller.
        // This is left as is from your original code, but consider moving the auth logic to the service.
        boolean isAuthenticated = GymOwnerDAO.authenticateUser(email, password);

        Map<String, String> jsonResponse = new HashMap<>();

        if (isAuthenticated) {
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "Login successful.");
            return Response.ok(jsonResponse).build();
        } else {
            jsonResponse.put("status", "error" + email + password);
            jsonResponse.put("message", "Invalid email or password.");
            return Response.status(Response.Status.UNAUTHORIZED).entity(jsonResponse).build();
        }
    }


    @POST
    @Path("/user/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(@FormParam("name") String name,
                               @FormParam("address") String address,
                               @FormParam("email") String email,
                               @FormParam("phone") String phone,
                               @FormParam("password") String password)
    {
        // It's better practice to call the business service layer, not the DAO directly from the controller.
        // This is left as is from your original code, but consider moving the auth logic to the service.
        GymCustomer gymCustomer = GymCustomerBusinessService.createProfile(name, address, email, phone, password);
        gymCustomer.setName(name);
        gymCustomer.setDescription("user");
        gymCustomer.setUserId(name);
        // Check if the user profile was successfully created.
        if (gymCustomer != null) {
            return Response.status(Response.Status.CREATED).entity(gymCustomer).build();
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "User registration failed. The email might already exist or input is invalid.");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
    }

    @POST
    @Path("/owner/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginOwner(@FormParam("name") String name,
                               @FormParam("address") String address,
                               @FormParam("email") String email,
                               @FormParam("phone") String phone,
                               @FormParam("gst") String gst,
                               @FormParam("password") String password)
    {
        // It's better practice to call the business service layer, not the DAO directly from the controller.
        // This is left as is from your original code, but consider moving the auth logic to the service.
        GymOwnerBusinessService gymOwnerBusinessService = new GymOwnerBusinessService();
        GymOwner gymOwner = gymOwnerBusinessService.AddGymOwnerDetails(name, address, email, phone, gst, password);
        gymOwner.setName(name);
        gymOwner.setDescription("owner");
        gymOwner.setUserId(name);
        // Check if the user profile was successfully created.
        if (true) {
            return Response.status(Response.Status.CREATED).entity(gymOwner).build();
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "User registration failed. The email might already exist or input is invalid.");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
    }

    @GET
    @Path("/customer/viewbookings")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewUserBookings(@QueryParam("name") String name)
    {
        // It's better practice to call the business service layer, not the DAO directly from the controller.
        // This is left as is from your original code, but consider moving the auth logic to the service.
        String bookings = GymCustomerDAO.viewBookings(name);
        // Check if the user profile was successfully created.
        if (bookings!=null) {
            return Response.status(Response.Status.CREATED).entity(bookings).build();
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "User registration failed. The email might already exist or input is invalid.");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
    }

    @POST
    @Path("/owner/registerGymCenter")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerGymByOwner(
            @FormParam("gymOwnerEmail") String gymOwnerEmail,
            @FormParam("gymCenterName") String gymCenterName,
            @FormParam("gymCenterAddress") String gymCenterAddress,
            @FormParam("gymCenterPhone") String gymCenterPhone,
            @FormParam("SlotCount") int SlotCount
    ){
        GymOwnerBusinessService gymownerservice = new GymOwnerBusinessService();
        GymCentre newGym = gymownerservice.AddGymCenter(gymOwnerEmail,gymCenterName,gymCenterAddress, gymCenterPhone, SlotCount);
        if (true) {
            return Response.status(Response.Status.CREATED).entity(newGym).build();
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Owner registration failed. The email might already exist or input is invalid.");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
    }

    @GET
    @Path("/admin/viewApprovedGyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewApprovedGyms(){
        String approvedGyms = GymOwnerDAO.viewApprovedGyms(null);
        if(approvedGyms!=null){
            return Response.status(Response.Status.CREATED).entity(approvedGyms).build();
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "User registration failed. The email might already exist or input is invalid.");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
    }

    @GET
    @Path("/user/viewAvailableSlots")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAvailbleSlots(@QueryParam("name") String gymId){
        List<Integer> slotsForGym = GymCustomerDAO.GymBookings.get(gymId);
        if(slotsForGym!=null){
            return Response.status(Response.Status.CREATED).entity(slotsForGym).build();
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "User registration failed. The email might already exist or input is invalid.");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
    }

    @POST
    @Path("/user/bookSlot")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookSlot(
            @FormParam("name") String name,
            @FormParam("gymName") String gymName,
            @FormParam("startTime") int startTime,
            @FormParam("endTime") int endTime,
            @FormParam("shift") String shift
    ){
        Slot newSlot = GymCustomerDAO.bookSlotApi(name,gymName,startTime,endTime,shift);
        if(newSlot!=null){
            return Response.status(Response.Status.CREATED).entity(newSlot).build();
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "User registration failed. The email might already exist or input is invalid.");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        }
    }
}
