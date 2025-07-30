package arg.acme.controller.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequestDto(
        @NotBlank String nome,
        @NotNull Integer age) {
}
