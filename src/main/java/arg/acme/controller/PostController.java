package arg.acme.controller;

import arg.acme.controller.dto.Content;
import arg.acme.usecases.CreatePostUseCase;
import arg.acme.usecases.ListPostUseCase;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class PostController {

    @Inject
    private ListPostUseCase listPostUseCase;

    @Inject
    private CreatePostUseCase createPostUseCase;

    @GET
    @Path("/{id}")
    public Response listarPosts(@PathParam("id") UUID userId) {
        return Response.ok(listPostUseCase.execute(userId)).build();
    }

    @POST
    @Path("/{id}")
    public Response createPost(@PathParam("id") UUID userId,@Valid Content content) {
        createPostUseCase.execute(userId, content);
        return Response.status(Response.Status.CREATED).build();
    }

}
