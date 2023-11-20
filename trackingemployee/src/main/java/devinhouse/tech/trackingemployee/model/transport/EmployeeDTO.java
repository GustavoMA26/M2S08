package devinhouse.tech.trackingemployee.model.transport;

import devinhouse.tech.trackingemployee.model.Employee;

public record EmployeeDTO(Integer id, String name, String position) {

    public EmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getPosition());

    }
}
