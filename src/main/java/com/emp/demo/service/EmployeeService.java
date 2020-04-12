package com.emp.demo.service;

import com.emp.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> empList=new ArrayList<>();
    public Employee saveEmployee(Employee emp) throws Exception{

         //   for(Employee obj:empList){
           //     if(obj.getId()==emp.getId()){
             //     throw new Exception("Employee id already exists : "+emp.getId());
               // }
            //}
            empList.add(emp);
            return emp;

    }

    public Employee getById(Integer id)throws Exception{
        for(Employee emp:empList){
           if(emp.getId()==id){
               return emp;
           }
        }
        throw new Exception("Employee ID " + id + " not found");
    }
}
