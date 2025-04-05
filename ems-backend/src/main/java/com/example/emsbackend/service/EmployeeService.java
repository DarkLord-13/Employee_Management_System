package com.example.emsbackend.service;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee);

    void deleteById(Long id);
}
