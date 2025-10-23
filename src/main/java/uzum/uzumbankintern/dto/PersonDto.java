package uzum.uzumbankintern.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record PersonDto(
        @NotNull(message = "name not be null") String name,
        @NotNull @Pattern(regexp = "^((3[01]|[12][0-9]|0[1-9]).1[0-2]|0[1-9]).[0-9]{4}$",
                message = "Invalid Format") String birthDate
) {
}
