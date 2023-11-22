package com.kotlinbackendproject.repository

import com.kotlinbackendproject.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository :JpaRepository<Employee,Long> {
}