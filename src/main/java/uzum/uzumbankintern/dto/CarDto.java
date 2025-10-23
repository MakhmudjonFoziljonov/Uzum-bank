package uzum.uzumbankintern.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CarDto(
        @NotNull @Pattern(regexp = "[a-zA-Z]+-[a-zA-Z0-9]+", message = "Invalid format") String model,
        @NotNull(message = "horsePower not be null") Integer horsePower,
        @NotNull(message = "ownerId not be null") Long ownerId
) {
}
