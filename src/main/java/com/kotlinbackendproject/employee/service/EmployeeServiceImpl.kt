package com.kotlinbackendproject.employee.service

import com.kotlinbackendproject.company.entity.Company
import com.kotlinbackendproject.company.repository.CompanyRepository
import com.kotlinbackendproject.employee.command.EmployeeCreateCommand
import com.kotlinbackendproject.employee.command.EmployeeUpdateCommand
import com.kotlinbackendproject.employee.factory.EmployeeFactory
import com.kotlinbackendproject.employee.entity.Department
import com.kotlinbackendproject.employee.entity.Employee
import com.kotlinbackendproject.employee.entity.EmployeeDto
import com.kotlinbackendproject.employee.repository.EmployeeRepository
import org.modelmapper.ModelMapper
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service

class EmployeeServiceImpl (
        private var employeeRepository: EmployeeRepository,
        private val modelMapper: ModelMapper,
        private val employeeFactory: EmployeeFactory,
        private val companyRepository: CompanyRepository): EmployeeService {
    override fun getEmployeeById(id: Long): EmployeeDto {
        val optionalEmployee=employeeRepository.findById(id)
        return optionalEmployee.map { employee -> modelMapper.map(employee, EmployeeDto::class.java)}.orElse(null)
    }

    override fun getAllEmployee(): List<EmployeeDto> {
        val employeeList:List<Employee> =employeeRepository.findAll()
        val employeeDtoList : MutableList<EmployeeDto> = mutableListOf()

        for (employee in employeeList){
            val employeeDto: EmployeeDto = modelMapper.map(employee, EmployeeDto::class.java)
            employeeDtoList.add(employeeDto)
        }
        return employeeDtoList
    }
    override fun createEmployee(command: EmployeeCreateCommand): Employee {
       val employee1=employeeFactory.createEmployee(command)
        return employeeRepository.save(employee1)
    }

    override fun updateEmployee(id: Long, command: EmployeeUpdateCommand): Employee {
       val employee1 = employeeRepository.findById(id).get()
        employee1.update(command)
        return employeeRepository.save(employee1)
    }

    override fun deleteEmployee(id: Long) {
        return employeeRepository.deleteById(id)
    }

    override fun getEmployeeByASC(): List<Employee> {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"age"))
    }

    override fun getEmployeeByDESC(): List<Employee> {
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"age"))
    }

    override fun getFindByDepartment(department: Department): List<EmployeeDto> {
        val employeeList:List<Employee> =employeeRepository.findByDepartment(department)
        val employeeDtoList:MutableList<EmployeeDto> = mutableListOf()

        for (employee in employeeList){
            val employeeDto: EmployeeDto =modelMapper.map(employee, EmployeeDto::class.java)
            employeeDtoList.add(employeeDto)
        }
        return employeeDtoList
    }

    override fun getFindByNameSurname(name: String, surname: String): List<EmployeeDto> {
        val employeeList:List<Employee> = employeeRepository.findByNameContainsAndSurnameContainsIgnoreCase(name, surname)
        val employeeDtoList:MutableList<EmployeeDto> = mutableListOf()

        for (employee in employeeList){
            val employeeDto: EmployeeDto =modelMapper.map(employee, EmployeeDto::class.java)
            employeeDtoList.add(employeeDto)
        }
        return employeeDtoList
    }

    override fun getByCompanyId(id: Long): List<Employee> {
       return employeeRepository.findAllByCompanyId(id)
    }

    override fun getExistingCompanyId(id: Long): Boolean {
        return employeeRepository.existsAllByCompanyId(id)
    }
}