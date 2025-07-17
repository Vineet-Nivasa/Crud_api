package com.example.crudapi.controller

import com.example.crudapi.model.Employee
import com.example.crudapi.repository.EmployeeRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping
    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    @PostMapping
    fun createEmployee(@RequestBody employee: Employee): Employee = employeeRepository.save(employee)

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): Employee =
        employeeRepository.findById(id).orElseThrow { RuntimeException("Employee not found") }

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @RequestBody updatedEmployee: Employee): Employee {
        val employee = employeeRepository.findById(id)
            .orElseThrow { RuntimeException("Employee not found") }

        val newEmployee = employee.copy(
            name = updatedEmployee.name,
            email = updatedEmployee.email,
            department = updatedEmployee.department
        )

        return employeeRepository.save(newEmployee)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long) {
        if (!employeeRepository.existsById(id)) {
            throw RuntimeException("Employee not found")
        }
        employeeRepository.deleteById(id)
    }
}
