package com.kotlinbackendproject.employee.factory

import com.kotlinbackendproject.company.entity.Company
import com.kotlinbackendproject.employee.command.EmployeeCreateCommand
import com.kotlinbackendproject.employee.entity.Employee
import org.springframework.stereotype.Component

@Component
class EmployeeFactory {
    fun createEmployee(command: EmployeeCreateCommand):Employee{
        val employee = Employee().apply {
            name=command.name
            surname=command.surname
            age=command.age
            email=command.email
            department=command.department
            company= Company().apply { id=command.companyId }
        }
        return employee
    }
}