package devinhouse.tech.trackingemployee.model.transport;

import devinhouse.tech.trackingemployee.model.enums.RegisterType;
import jakarta.validation.constraints.NotNull;

public record CreateRegisterDTO(@NotNull RegisterType registerType) {
}
