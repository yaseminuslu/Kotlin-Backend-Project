package com.kotlinbackendproject.company.service

import com.kotlinbackendproject.company.entity.Company
import com.kotlinbackendproject.company.specification.CompanyFilter

interface CompanyService {
    fun getByCompanyId(id:Long):Company
    fun getAllCompany():List<Company>
    fun createCompany(company: Company):Company
    fun updateCompany(id:Long,company: Company):Company
    fun deleteCompany(id:Long)
    fun getCompanyIdASC():List<Company>
    fun getCompanyIdDESC():List<Company>
    fun getAllByFilter(filter: CompanyFilter):List<Company>
}