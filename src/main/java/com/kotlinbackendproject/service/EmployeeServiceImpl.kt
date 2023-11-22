package com.kotlinbackendproject.service

import com.kotlinbackendproject.entity.Employee
import com.kotlinbackendproject.entity.EmployeeDto
import com.kotlinbackendproject.repository.EmployeeRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service

class EmployeeServiceImpl (private var employeeRepository: EmployeeRepository, private val modelMapper: ModelMapper):EmployeeService {
    override fun getEmployeeById(id: Long): EmployeeDto {
        val optionalEmployee=employeeRepository.findById(id)
        return optionalEmployee.map { employee -> modelMapper.map(employee, EmployeeDto::class.java)}.orElse(null)
    }

    override fun getAllEmployee(): List<EmployeeDto> {
        val employeeList:List<Employee> =employeeRepository.findAll()
        val employeeDtoList : MutableList<EmployeeDto> = mutableListOf()

        for (employee in employeeList){
            val employeeDto:EmployeeDto = modelMapper.map(employee, EmployeeDto::class.java)
            employeeDtoList.add(employeeDto)
        }
        return employeeDtoList
    }

    override fun createEmployee(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    override fun updateEmployee(id: Long, employee: Employee): Employee {
        val employee1=employeeRepository.findById(id).get()
        employee1.name=employee.name
        employee1.surname=employee.surname
        employee1.age=employee.age
        employee1.email=employee.email
        employee1.department=employee.department
        return employeeRepository.save(employee1)
    }

    override fun deleteEmployee(id: Long) {
        return employeeRepository.deleteById(id)
    }
}