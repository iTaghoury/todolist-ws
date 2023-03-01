package fr.m2i.todolist.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/todo")
public class TodoResource {
    @GET
    @Path("/todo/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTodo(@PathParam("id") int id){
        return null;
    }
}
