package arg.acme.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record Content(

        @NotBlank String body
) {
}
