package fr.m2i.todolist.api;

import fr.m2i.todolist.model.Todo;
import fr.m2i.todolist.model.Urgence;
import fr.m2i.todolist.util.TodoHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.print.attribute.standard.Media;

@Path("/todo")
public class TodoResource {
    private TodoHandler th = TodoHandler.getInstance();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTodo(@QueryParam("id") int id){
        return th.getTodoFromId(id);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTodoList() {
        return String.format("%s", th.viewTodoList()) ;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createTodo(@FormParam("titre") String titre, @FormParam("description") String description, @FormParam("urgence") String urgence) {
        th.addTodo(new Todo(titre, description, urgence));
        return String.format("Added Todo : %s\nCurrent list : %s", th.getTodoList().get(th.getTodoList().size()-1).toString(), th.viewTodoList());
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateTodo(@FormParam("id") int id, @FormParam("titre") String titre, @FormParam("description") String description, @FormParam("urgence") String urgence) {
        th.updateTodoFromId(id, new Todo(titre, description, urgence));
        return String.format("Updated Todo %d\nCurrent List : \n%s", id, th.viewTodoList());
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteTodo(@QueryParam("id") int id) {
        String message = String.format("Removed Todo : %s", th.getTodoFromId(id));
        th.deleteTodo(id);
        return message;
    }
}
