package arg.acme.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"error\": \"Erro interno do servidor: " + e.getMessage() + "\"}")
                .type("application/json")
                .build();
    }

}