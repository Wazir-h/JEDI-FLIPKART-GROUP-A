package com.flipfit.rest;
import  com.flipfit.*;
import javax.ws.rs.*;
//@PATH("/GymOwner")
public class GymOwnerflipfitrest {
//    @Path("/centers")
//    @POST
//    private String GymCenterAddress;
//    private boolean isApproved = false;
//    private int SlotCount;
//    private String GymName;
//    private String GymID;
//    private String GymCenterPhone;
//
//    public Response addGymCenter(GymCenter gymCenter, @QueryParam("userName") String userName) {
//        try {
//            boolean success = gymOwnerBusinessService.AddGymCenter(
//                    userName,
//                    gymCenter.getGymName(),
//                    gymCenter.getCenterAddress(),
//                    gymCenter.getGymCenterPhone(),
//                    gymCenter.getSlotCountt()
//            );
//
//            if (success) {
//                return Response.status(Response.Status.CREATED).entity("{\"message\":\"Gym Center added successfully.\"}").build();
//            } else {
//                return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\":\"Failed to add Gym Center.\"}").build();
//            }
//        } catch (Exception exception) {
//            // Handle any unexpected errors
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"" + exception.getMessage() + "\"}").build();
//        }
//    }
//
//    @Path("/centers/{userName}")
//    @GET
//    public Response viewGymCenters(@PathParam("userName") String userName) {
//        try {
//            return Response.ok().entity(gymOwnerBusinessService.viewAllGymCenters(userName);).build();
//        } catch (Exception exception) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"" + exception.getMessage() + "\"}").build();
//        }
//    }
//
//    @Path("/centers/{userName}/{gymName}")
//    @DELETE
//    public Response deleteGymCenter(@PathParam("userName") String userName, @PathParam("gymName") String gymName) {
//        try {
//            boolean success = gymOwnerBusinessService.  DeleteGymCenter(userName, gymName);
//            if (success) {
//                return Response.ok().entity("{\"message\":\"Gym Center '" + gymName + "' deleted successfully.\"}").build();
//            } else {
//                return Response.status(Response.Status.NOT_FOUND).entity("{\"error\":\"Gym Center not found or could not be deleted.\"}").build();
//            }
//        } catch (Exception exception) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"" + exception.getMessage() + "\"}").build();
//        }
//    }
}
