package arg.acme.controller.dto;

import java.util.UUID;

public record FollowerResponse(
        UUID id,
        String name
) {
}
