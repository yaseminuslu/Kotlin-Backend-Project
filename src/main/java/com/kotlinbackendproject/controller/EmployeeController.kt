package com.kotlinbackendproject.controller

import com.kotlinbackendproject.entity.Employee
import com.kotlinbackendproject.entity.EmployeeDto
import com.kotlinbackendproject.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
class EmployeeController (private val employeeService: EmployeeService) {
    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id:Long): EmployeeDto {
        return employeeService.getEmployeeById(id)
    }
    @GetMapping
    fun getAllEmployee():List<EmployeeDto>{
        return employeeService.getAllEmployee()
    }
    @PostMapping
    fun createEmployee(@RequestBody employee: Employee):Employee{
        return employeeService.createEmployee(employee)
    }
    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id:Long, @RequestBody employee: Employee):Employee{
        return employeeService.updateEmployee(id, employee)
    }
    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id:Long){
        employeeService.deleteEmployee(id)
    }
    @GetMapping("/asc")
    fun getEmployeeByASC():List<Employee>{
        return employeeService.getEmployeeByASC()
    }
    @GetMapping("/desc")
    fun getEmployeeByDESC():List<Employee>{
        return employeeService.getEmployeeByDESC()
    }

}