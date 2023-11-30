package com.kotlinbackendproject.employee.command

import com.kotlinbackendproject.employee.entity.Department

data class EmployeeUpdateCommand(
        val id:Long,
        val name:String?,
        val surname:String?,
        val age:Int?,
        val email:String?,
        val department: Department?,
        val companyId:Long?) {

} 