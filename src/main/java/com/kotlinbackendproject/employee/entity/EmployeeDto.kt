package com.kotlinbackendproject.employee.entity

import com.kotlinbackendproject.company.entity.Company

class EmployeeDto {
    var id: Long?=null
    lateinit var name:String
    lateinit var surname:String
    lateinit var department: Department
    lateinit var company:Company
}