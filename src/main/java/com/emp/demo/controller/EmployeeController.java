package com.emp.demo.controller;

import com.emp.demo.model.Employee;
import com.emp.demo.service.EmployeeService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employeeservice")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value="/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee saveEmployee(@RequestBody Employee emp) throws Exception{
        if(emp==null){
            throw new Exception("Employee is invalid" );
        }

       else if(emp.getId()==null || emp.getId()==0){
            throw new Exception("Employee id is invalid : " +emp.getId());
        }
        else if(emp.getLocation()==null || "string".equals(emp.getLocation())){
            throw new Exception("Employee location is invalid : " +emp.getLocation());
        }
        else if(emp.getName()==null || emp.getName().isEmpty() || "string".equals(emp.getName())){
            throw new Exception("Employee name is invalid : " +emp.getName());
        }
        else if(emp.getSalary()==null || emp.getSalary()==0){
            throw new Exception("Employee salary is invalid : " +emp.getSalary());
        }

      return   employeeService.saveEmployee(emp);
    }

    @GetMapping(value="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmpById(@PathVariable Integer id) throws Exception{
       return employeeService.getById(id);
    }
}
