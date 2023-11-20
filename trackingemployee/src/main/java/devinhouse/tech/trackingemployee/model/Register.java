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

    public Register() {
    }

    public Register(Integer id, LocalDateTime registeredTime, RegisterType registerType, Employee employee) {
        this.id = id;
        this.registeredTime = registeredTime;
        this.registerType = registerType;
        this.employee = employee;
    }

    public Register(RegisterType registerType, Employee employee) {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(LocalDateTime registeredTime) {
        this.registeredTime = registeredTime;
    }

    public RegisterType getRegisterType() {
        return registerType;
    }

    public void setRegisterType(RegisterType registerType) {
        this.registerType = registerType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
