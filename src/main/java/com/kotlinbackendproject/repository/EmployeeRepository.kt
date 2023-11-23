package com.kotlinbackendproject.repository

import com.kotlinbackendproject.entity.Department
import com.kotlinbackendproject.entity.Employee
import com.kotlinbackendproject.entity.EmployeeDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository :JpaRepository<Employee,Long> {
    fun findByDepartment(department: Department):List<Employee>
    fun findByNameContainsAndSurnameContainsIgnoreCase(name:String,surname:String):List<Employee>
}