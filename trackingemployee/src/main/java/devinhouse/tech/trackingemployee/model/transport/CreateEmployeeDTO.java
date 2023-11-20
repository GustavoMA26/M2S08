package devinhouse.tech.trackingemployee.model.transport;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEmployeeDTO(@NotBlank String name, @NotBlank String position, @NotNull Float salary ) {

}
