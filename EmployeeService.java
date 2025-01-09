package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class EmployeeService {
@Autowired
 private EmployeeRepository emp;
public List<Employee> getAllEmployees() {
    return emp.findAll();
}
public Employee getEmployeeById(Long id) {
    return emp.findById(id).orElse(null);
}
public Employee createEmployee(Employee employee) {
    return emp.save(employee);
}
public Employee updateEmployee(Long id, Employee updatedEmployee) {
    Employee existingEmployee = emp.findById(id).orElse(null);
    if (existingEmployee != null) {
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        return emp.save(existingEmployee);
    }
    return null;
}
public void deleteEmployee(Long id) {
    emp.deleteById(id);
}
}
