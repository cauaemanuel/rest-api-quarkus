package arg.acme.controller;

import arg.acme.controller.dto.FollowerRequest;
import arg.acme.usecases.CreateFollowerUseCase;
import arg.acme.usecases.ListFollowersUseCase;
import arg.acme.usecases.UnFollowerUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Path("/followers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class FollowersController {

    @Inject
    private CreateFollowerUseCase createFollowerUseCase;
    @Inject
    private ListFollowersUseCase listFollowersUseCase;
    @Inject
    private UnFollowerUseCase unFollowerUseCase;

    @PUT
    @Path("/{userId}")
    public Response followUser(
            @PathParam("userId") UUID userId, FollowerRequest request){
        createFollowerUseCase.execute(userId, request.followerId());
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{userId}")
    public Response getFollowers(@PathParam("userId") UUID userId) {
        return Response.ok(listFollowersUseCase.listarSeguidoresPorUsuario(userId)).build();
    }

    @DELETE
    @Path("/{userId}/{followerId}")
    public Response unfollowUser(
            @PathParam("userId") UUID userId,
            @QueryParam("followerId") UUID followerId) {
        unFollowerUseCase.unfollowUser(userId, followerId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
