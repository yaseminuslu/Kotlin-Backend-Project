package com.kotlinbackendproject.company.service

import com.kotlinbackendproject.company.entity.Company
import com.kotlinbackendproject.company.repository.CompanyRepository
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.AbstractPersistable_
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class CompanyServiceImpl(private val companyRepository: CompanyRepository):CompanyService {
    override fun getByCompanyId(id: Long): Company {
        return companyRepository.findById(id).get()
    }

    override fun getAllCompany(): List<Company> {
        return companyRepository.findAll()
    }

    override fun createCompany(company: Company): Company {
        return companyRepository.save(company)
    }

    override fun updateCompany(id: Long, company: Company): Company {
        val upCompany=companyRepository.findById(id).get()
        upCompany.name=company.name
        upCompany.address=company.address
        upCompany.date=company.date
        return companyRepository.save(upCompany)
    }

    override fun deleteCompany(id: Long) {
        return companyRepository.deleteById(id)
    }

    override fun getCompanyIdASC(): List<Company> {
        return companyRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
    }

    override fun getCompanyIdDESC(): List<Company> {
        return companyRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
    }

}