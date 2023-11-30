package com.kotlinbackendproject.employee.controller

import com.kotlinbackendproject.employee.command.EmployeeCreateCommand
import com.kotlinbackendproject.employee.command.EmployeeUpdateCommand
import com.kotlinbackendproject.employee.entity.Department
import com.kotlinbackendproject.employee.entity.Employee
import com.kotlinbackendproject.employee.entity.EmployeeDto
import com.kotlinbackendproject.employee.service.EmployeeService
import com.kotlinbackendproject.employee.specification.EmployeeFilter
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
    fun createEmployee(@RequestBody employee: EmployeeCreateCommand): Employee {
        return employeeService.createEmployee(employee)
    }
    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id:Long, @RequestBody employee: EmployeeUpdateCommand): Employee {
        return employeeService.updateEmployee(id,employee)
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
    @GetMapping("/department")
    fun getFindByDepartment( @RequestParam(value = "department") department: Department):List<EmployeeDto>{
        return employeeService.getFindByDepartment(department)
    }
    @GetMapping("/search")
    fun getFindByNameSurname(@RequestParam(value = "name") name:String,
                             @RequestParam(value = "surname") surname:String):List<EmployeeDto>{
        return employeeService.getFindByNameSurname(name, surname)
    }
    @GetMapping("/company/{id}")
    fun getByCompanyId( @PathVariable("id") id:Long):List<Employee>{
        return employeeService.getByCompanyId(id)
    }
    @GetMapping("/companyExisting/{id}")
    fun getExistingCompanyId( @PathVariable("id") id:Long):Boolean{
        return employeeService.getExistingCompanyId(id)
    }

    @GetMapping("/filter")
    fun getEmployeesByFilter(filter: EmployeeFilter): List<Employee> {
        return employeeService.getAllByFilter(filter)
    }

}