package com.kotlinbackendproject.employee.service

import com.kotlinbackendproject.employee.command.EmployeeCreateCommand
import com.kotlinbackendproject.employee.command.EmployeeUpdateCommand
import com.kotlinbackendproject.employee.entity.Department
import com.kotlinbackendproject.employee.entity.Employee
import com.kotlinbackendproject.employee.entity.EmployeeDto
import com.kotlinbackendproject.employee.specification.EmployeeFilter

interface EmployeeService {
    fun getEmployeeById(id:Long): EmployeeDto
    fun getAllEmployee():List<EmployeeDto>
    fun createEmployee(command: EmployeeCreateCommand): Employee
    fun updateEmployee(id:Long, employee: EmployeeUpdateCommand): Employee
    fun deleteEmployee(id: Long)
    fun getEmployeeByASC():List<Employee>
    fun getEmployeeByDESC():List<Employee>
    fun getFindByDepartment(department: Department):List<EmployeeDto>
    fun getFindByNameSurname(name:String, surname:String):List<EmployeeDto>
    fun getByCompanyId(id:Long):List<Employee>
    fun getExistingCompanyId(id: Long):Boolean
    fun getAllByFilter(filter: EmployeeFilter):List<Employee>
}