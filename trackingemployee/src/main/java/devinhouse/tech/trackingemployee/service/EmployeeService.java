package devinhouse.tech.trackingemployee.service;

import devinhouse.tech.trackingemployee.model.Employee;
import devinhouse.tech.trackingemployee.model.transport.CreateEmployeeDTO;
import devinhouse.tech.trackingemployee.model.transport.EmployeeDTO;
import devinhouse.tech.trackingemployee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public EmployeeDTO create(CreateEmployeeDTO body) {
        Employee newEmployee = new Employee(body);
        this.employeeRepository.save(newEmployee);
        return new EmployeeDTO(newEmployee);
    }
}
