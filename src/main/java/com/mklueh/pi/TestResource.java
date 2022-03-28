package com.mklueh.pi;

import com.pi4j.context.Context;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Marian at 28.03.2022
 */
@Slf4j
@Path("/")
@RequestScoped
public class TestResource {

    @Inject
    Context context;

    @Inject
    LightBulb lightBulb;

    @GET
    @Path("light")
    @Produces(MediaType.TEXT_PLAIN)
    public Response light() {
        return Response.accepted(lightBulbStatus()).build();
    }

    private String lightBulbStatus() {
        return lightBulb.isOn() ? "Light is currently on" : "Light is currently off";
    }

    @POST
    @Path("light")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response toggle() {
        lightBulb.toggle();
        return Response.accepted(lightBulbStatus()).build();
    }

}
