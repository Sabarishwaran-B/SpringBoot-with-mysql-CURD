package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
@Autowired
private EmployeeService emp;
@GetMapping
public List<Employee> getAllEmployee(){
	return emp.getAllEmployees();
}
@GetMapping("/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
	Employee e=emp.getEmployeeById(id);
	if(e!=null) {
		return ResponseEntity.ok(e);
	}
	return ResponseEntity.notFound().build();
}
@PostMapping
public Employee createEmployee(@RequestBody Employee e) {
	return emp.createEmployee(e);
}
@PutMapping("/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
    Employee employee = emp.updateEmployee(id, updatedEmployee);
    if (employee != null) {
        return ResponseEntity.ok(employee);
    }
    return ResponseEntity.notFound().build();
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    emp.deleteEmployee(id);
    return ResponseEntity.noContent().build();
}
}
