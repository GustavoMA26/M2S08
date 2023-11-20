package devinhouse.tech.trackingemployee.model.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import devinhouse.tech.trackingemployee.model.Register;
import devinhouse.tech.trackingemployee.model.enums.RegisterType;

import java.time.LocalDateTime;

public record RegisterDTO(Integer id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registeredTime, RegisterType registerType) {

    public RegisterDTO(Register register) {
        this(register.getId(), register.getRegisteredTime(), register.getRegisterType());
    }
}
