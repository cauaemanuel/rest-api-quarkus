package arg.acme.controller;

import arg.acme.usecases.SavePessoaUseCase;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {

    private SavePessoaUseCase savePessoaUseCase;

    @POST
    @Path("/criar")
    private Response salvarPessoa(){

    }
}
