package com.flipfit.rest;
import  com.flipfit.*;
import javax.ws.rs.*;

@Path("/Gymcustomer")
public class GymCustomerClientRestService{

    public static void customerPage(String userName,String userPassword,int roleId){
        GymCustomer gymCustomer=new GymCustomer();
        GymCustomerDAO.loadBookingDetails(userName);
        gymCustomer.setUserName(userName);
        gymCustomer.setUserPassword(userPassword);
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf ("              Welcome %-68s ║\n", userName + " to FlipFit");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("                            🧍‍♂️ Customer Dashboard 🧍‍♀️                            ");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                                 ║");
        System.out.println("║   1. Update Profile                                                             ║");
        System.out.println("║   2. View All Gyms                                                              ║");
        System.out.println("║   3. View All Bookings                                                          ║");
        System.out.println("║   4. Book Slot                                                                  ║");
        System.out.println("║   5. Cancel Slot                                                                ║");
        System.out.println("║   6. View Available Slots                                                       ║");
        System.out.println("║   7. Log Out                                                                    ║");
        System.out.println("║                                                                                 ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
        System.out.print("👉 Enter option to move next (1–7): ");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
            switch (choice) {
                case 1:
                    performUpdateProfile(gymCustomer);
                    break;
                case 2:
                    viewAllGyms();
                    break;
                case 3:
                    viewAllBookings(userName);
                    break;
                case 4:
                    bookSlot(userName);
                    break;
                case 5:
                    cancelSlot(userName);
                    break;
                case 6:
                    viewAllAvailableSlots();
                    break;
                default:
                    System.out.println("Logout Successful");
                    return;
            }
            customerPage(userName, userPassword,roleId);
        } catch(Exception e){
            System.out.println("Enter Correct Value");
            customerPage(userName, userPassword,roleId);
        }
    }
    @Path("updateProfile")
    @PUT
    public static void  performUpdateProfile(GymCustomer gymCustomer){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        try {
            boolean success = gymCustomerBusinessService.updateProfile(gymCustomer);
            if (success) {
                return Response.ok().entity("Profile updated successfully.").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Profile update failed.").build();
            }
        } catch (Exception exception) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
        }
    }
    @Path("viewAllGyms")
    @GET
    public static void viewAllGyms(){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        try{
            return Response.ok().entity(gymCustomerBusinessService.viewAllGyms()).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("viewAllBookings")
    @GET
    public static void viewAllBookings(String userName){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        try{
            return Response.ok().entity(gymCustomerBusinessService.viewAllBookings(userName)).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("bookSlot")
    @POST
    public static void bookSlot(String userName){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        try{
            return Response.ok().entity(gymCustomerBusinessService.bookSlot(userName)).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("bookSlot")
    @POST
    public static void bookSlot(String userName){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        try{
            return Response.ok().entity(gymCustomerBusinessService.bookSlot(userName)).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("cancelSlot")
    @DELETE
    public static void cancelSlot(String userName){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        try{
            return Response.ok().entity(gymCustomerBusinessService.cancelSlot(userName)).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
    @Path("viewAvailableSlot")
    @GET
    public static void viewAllAvailableSlots(){
        GymCustomerBusinessServiceInterface gymCustomerBusinessService = new GymCustomerBusinessService();
        try{
            return Response.ok().entity(gymCustomerBusinessService.viewAllAvailableSlots()).build();
        } catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

}
