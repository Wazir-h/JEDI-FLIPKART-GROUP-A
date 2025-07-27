package com.flipfit.rest;

import javax.ws.rs.*;

@Path("/helloservice")
public class HelloTestRest {
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

}
