package arg.acme.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreatePessoaDto(
        @NotBlank String nome,
        @NotBlank @Email String email) {
}
