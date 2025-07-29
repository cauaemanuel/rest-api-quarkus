package arg.acme.controller;

import arg.acme.controller.dto.CreatePessoaDto;
import arg.acme.usecases.DeletarPessoaUseCase;
import arg.acme.usecases.ListarPessoasUseCase;
import arg.acme.usecases.SavePessoaUseCase;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {

    private final SavePessoaUseCase savePessoaUseCase;
    private final ListarPessoasUseCase listarPessoasUseCase;
    private final DeletarPessoaUseCase deletarPessoaUseCase;

    public PessoaController(SavePessoaUseCase savePessoaUseCase,
                            ListarPessoasUseCase listarPessoasUseCase,
                            DeletarPessoaUseCase deletarPessoaUseCase) {
        this.savePessoaUseCase = savePessoaUseCase;
        this.listarPessoasUseCase = listarPessoasUseCase;
        this.deletarPessoaUseCase = deletarPessoaUseCase;
    }

    @POST
    @Path("/criar")
    public Response salvarPessoa(@Valid CreatePessoaDto createPessoaDto){
        savePessoaUseCase.execute(createPessoaDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listarPessoas() {
        return Response.ok(listarPessoasUseCase.listarPessoas()).build();
    }

    @GET
    @Path("/{id}")
    public Response listarPessoaPorId(@PathParam("id") Long id) {
        return Response.ok(listarPessoasUseCase.listarPessoaPorId(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarPessoa(@PathParam("id") Long id) {
        deletarPessoaUseCase.deletarPessoa(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarPessoa(@PathParam("id") Long id, CreatePessoaDto createPessoaDto) {
        return Response.ok().build();
    }

}
