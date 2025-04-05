package com.example.emsbackend.service.implementation;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.exception.ResourceNotFoundException;
import com.example.emsbackend.mapper.EmployeeMapper;
import com.example.emsbackend.repository.EmployeeRepository;
import com.example.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saved);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee e = employeeRepository.findById(id) // another way of using the Optional<> class
                .orElseThrow(()-> new ResourceNotFoundException(("Employee does not exists of the id: " + id)));

        return EmployeeMapper.mapToEmployeeDto(e);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> list = employeeRepository.findAll();

        List<EmployeeDto> list2 = new ArrayList<>();
        for(Employee e: list){
            list2.add(EmployeeMapper.mapToEmployeeDto(e));
        }

        return list2;
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee) {
        Employee e = employeeRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee with id: "+id+"does not exists"));

        e.setEmail(updateEmployee.getEmail());
        e.setFirstName(updateEmployee.getFirstName());
        e.setLastName(updateEmployee.getLastName());
        employeeRepository.save(e);

        return EmployeeMapper.mapToEmployeeDto(e);
    }

    @Override
    public void deleteById(Long id) {
        Employee e = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id: "+id+"does not exists"));

        employeeRepository.deleteById(id);
    }
}
