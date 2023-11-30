package com.kotlinbackendproject.employee.repository

import com.kotlinbackendproject.employee.entity.Department
import com.kotlinbackendproject.employee.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository :JpaRepository<Employee,Long>
, JpaSpecificationExecutor<Employee>{
    fun findByDepartment(department: Department):List<Employee>
    fun findByNameContainsAndSurnameContainsIgnoreCase(name:String,surname:String):List<Employee>
    fun findAllByCompanyId(id: Long):List<Employee>
    fun existsAllByCompanyId(id: Long):Boolean


}