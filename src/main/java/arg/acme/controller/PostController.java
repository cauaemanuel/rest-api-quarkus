package arg.acme.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class PostController {

    @Path("/{id}")
    public Response listarPosts() {
        // Implementar a lógica para listar posts
        return Response.ok().build();
    }


    @Path("/{id}")
    public Response createPost() {
        // Implementar a lógica para criar um post
        return Response.status(Response.Status.CREATED).build();
    }

}
