package arg.acme.controller.dto;

import java.util.List;
import java.util.UUID;

public record FollowersPerUserResponse(
        Integer folllowersCount,
        List<FollowerResponse> content
) {
}
