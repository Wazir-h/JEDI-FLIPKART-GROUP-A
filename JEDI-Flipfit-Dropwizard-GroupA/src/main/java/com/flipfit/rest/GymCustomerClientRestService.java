package com.flipfit.rest;
import com.flipfit.beans.GymCustomer;
import com.flipfit.business.GymCustomerBusinessService;
import com.flipfit.business.GymCustomerBusinessServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/Gymcustomer")
public class GymCustomerClientRestService{
    @GET
    @Path("/")
    public static String ok(){
        return "GymCustomerClientRestService";
    }//    @Path("/updateProfile")
//    @PUTf
//    public static void  performUpdateProfile(GymCustomer gymCustomer){
//        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
//        GymCustomer customer = new GymCustomer();
//        try {
//            gymCustomerBusinessService.updateProfile(gymCustomer);
//            if () {
//                return Response.ok().entity("Profile updated successfully.").build();
//            } else {
//                return Response.status(Response.Status.BAD_REQUEST).entity("Profile update failed.").build();
//            }
//        } catch (Exception exception) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
//        }
//    }
    @GET
    @Path("/viewAllGyms")
    public static String viewAllGyms(){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        return gymCustomerBusinessService.viewAllGyms();
    }
//    @Path("viewAllBookings")
//    @GET
//    public static void viewAllBookings(String userName){
//        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
//        try{
//            return Response.ok().entity(gymCustomerBusinessService.viewAllBookings(userName)).build();
//        } catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//    }
//    @Path("bookSlot")
//    @POST
//    public static void bookSlot(String userName){
//        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
//        try{
//            return Response.ok().entity(gymCustomerBusinessService.bookSlot(userName)).build();
//        } catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//    }
//    @Path("bookSlot")
//    @POST
//    public static void bookSlot(String userName){
//        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
//        try{
//            return Response.ok().entity(gymCustomerBusinessService.bookSlot(userName)).build();
//        } catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//    }
//    @Path("cancelSlot")
//    @DELETE
//    public static void cancelSlot(String userName){
//        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
//        try{
//            return Response.ok().entity(gymCustomerBusinessService.cancelSlot(userName)).build();
//        } catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//    }
//    @Path("viewAvailableSlot")
//    @GET
//    public static void viewAllAvailableSlots(){
//        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
//        try{
//            return Response.ok().entity(gymCustomerBusinessService.viewAllAvailableSlots()).build();
//        } catch(Exception exception){
//            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
//        }
//    }

}
