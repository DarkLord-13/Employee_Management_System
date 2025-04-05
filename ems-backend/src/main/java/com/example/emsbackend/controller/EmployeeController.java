package com.example.emsbackend.controller;

import com.example.emsbackend.dto.EmployeeDto;
import com.example.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // means all the clients can call employees related rest api's
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){ // @RequestBody-> extracts json from the http requests and converts it to EmployeeDto java object
        EmployeeDto saved = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{id}") // since the parameter name url variable name is different, we specify the name of the variable in the @PathVariable annotation itself
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long eid){
        return new ResponseEntity<>(employeeService.getEmployeeById(eid), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployeeById(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto edto){
        return new ResponseEntity<>(employeeService.updateEmployee(id, edto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return new ResponseEntity<>("Employee with id: "+id+" is deleted", HttpStatus.OK);
    }
}
