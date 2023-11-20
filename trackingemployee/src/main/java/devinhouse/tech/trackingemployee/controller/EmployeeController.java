package devinhouse.tech.trackingemployee.controller;

import devinhouse.tech.trackingemployee.model.transport.*;
import devinhouse.tech.trackingemployee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody @Valid CreateEmployeeDTO body) {
        EmployeeDTO response = this.employeeService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> listAll(@PageableDefault(size = 12, sort = "name") Pageable pageable) {
        Page<EmployeeDTO> response= this.employeeService.listAll(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecifiedEmployeeDTO> getById(@PathVariable("id") Integer id) {
        SpecifiedEmployeeDTO response = this.employeeService.getSpecificEmployee(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/registers")
    public ResponseEntity<RegisterDTO> createRegister(@PathVariable("id") Integer id, @RequestBody @Valid CreateRegisterDTO body) {
        RegisterDTO response = this.employeeService.createRegister(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}
