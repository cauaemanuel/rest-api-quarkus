package arg.acme.controller;

import arg.acme.controller.dto.CreateUserRequestDto;
import arg.acme.usecases.DeletarUserUseCase;
import arg.acme.usecases.ListarUserUseCase;
import arg.acme.usecases.SaveUserUseCase;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class UserController {

    private final SaveUserUseCase saveUserUseCase;
    private final ListarUserUseCase listarUserUseCase;
    private final DeletarUserUseCase deletarUserUseCase;


    @POST
    @Path("/criar")
    public Response salvarUser(@Valid CreateUserRequestDto createUserRequestDto){
        saveUserUseCase.execute(createUserRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listarUsers() {
        return Response.ok(listarUserUseCase.listarPessoas()).build();
    }

    @GET
    @Path("/{id}")
    public Response listarUserPorId(@PathParam("id") UUID id) {
        return Response.ok(listarUserUseCase.listarPessoaPorId(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarUser(@PathParam("id") UUID id) {
        deletarUserUseCase.deletarPessoa(id);
        return Response.noContent().build();
    }

}
