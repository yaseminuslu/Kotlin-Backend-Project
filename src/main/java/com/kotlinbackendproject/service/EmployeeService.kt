package com.kotlinbackendproject.service

import com.kotlinbackendproject.entity.Employee
import com.kotlinbackendproject.entity.EmployeeDto

interface EmployeeService {
    fun getEmployeeById(id:Long): EmployeeDto
    fun getAllEmployee():List<EmployeeDto>
    fun createEmployee(employee: Employee): Employee
    fun updateEmployee(id:Long, employee: Employee):Employee
    fun deleteEmployee(id: Long)
    fun getEmployeeByASC():List<Employee>
    fun getEmployeeByDESC():List<Employee>
}