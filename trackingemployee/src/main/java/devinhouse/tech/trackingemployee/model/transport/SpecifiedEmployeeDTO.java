package devinhouse.tech.trackingemployee.model.transport;

import devinhouse.tech.trackingemployee.model.Employee;

import java.util.List;

public record SpecifiedEmployeeDTO(Integer id, String name, String position, Float salary, List<RegisterDTO> registers) {

    public SpecifiedEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary(), employee.getRegisterAsObject());
    }
}
