package devinhouse.tech.trackingemployee.service;

import devinhouse.tech.trackingemployee.model.Employee;
import devinhouse.tech.trackingemployee.model.Register;
import devinhouse.tech.trackingemployee.model.transport.*;
import devinhouse.tech.trackingemployee.repository.EmployeeRepository;
import devinhouse.tech.trackingemployee.repository.RegisterRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Page<EmployeeDTO> listAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable).map(EmployeeDTO::new);
    }

    public SpecifiedEmployeeDTO getSpecificEmployee(Integer id) {
        return this.employeeRepository.findById(id).map(SpecifiedEmployeeDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Employee " + id + " doesn't exist"));
    }

    @Transactional
    public RegisterDTO createRegister(Integer id, CreateRegisterDTO body) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee " + id + " doesn't exist"));

        Register register = new Register(body.registerType(), employee);
        employee.getRegisters().add(register);

        return new RegisterDTO(register);
    }


}
