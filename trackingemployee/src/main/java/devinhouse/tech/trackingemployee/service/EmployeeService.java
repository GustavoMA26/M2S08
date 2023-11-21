package devinhouse.tech.trackingemployee.service;

import devinhouse.tech.trackingemployee.model.Employee;
import devinhouse.tech.trackingemployee.model.Register;
import devinhouse.tech.trackingemployee.model.transport.*;
import devinhouse.tech.trackingemployee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public EmployeeDTO create(CreateEmployeeDTO body) {
        LOGGER.info("Starting the employee's creation");
        Employee newEmployee = new Employee(body);
        this.employeeRepository.save(newEmployee);
        return new EmployeeDTO(newEmployee);
    }

    public Page<EmployeeDTO> listAll(Pageable pageable) {
        LOGGER.info("Listing all employees");
        return this.employeeRepository.findAll(pageable).map(EmployeeDTO::new);
    }

    public SpecifiedEmployeeDTO getSpecificEmployee(Integer id) {
        LOGGER.info("Listing all details from a specific employee");
        return this.employeeRepository.findById(id).map(SpecifiedEmployeeDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Employee " + id + " doesn't exist"));
    }

    @Transactional
    public RegisterDTO createRegister(Integer id, CreateRegisterDTO body) {
        LOGGER.info("Creating the employee's registers");
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee " + id + " doesn't exist"));

        Register register = new Register(body.registerType(), employee);
        employee.getRegisters().add(register);

        return new RegisterDTO(register);
    }


}
