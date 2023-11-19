package devinhouse.tech.trackingemployee.model;

import devinhouse.tech.trackingemployee.model.enums.RegisterType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "REGISTER")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime registeredTime;

    @Enumerated(EnumType.STRING)
    private RegisterType registerType;

    @ManyToOne
    @JoinColumn(name= "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;

}
