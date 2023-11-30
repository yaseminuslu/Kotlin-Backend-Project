package com.kotlinbackendproject.company.service

import com.kotlinbackendproject.company.entity.Company
import com.kotlinbackendproject.company.repository.CompanyRepository
import com.kotlinbackendproject.company.specification.CompanyFilter
import com.kotlinbackendproject.company.specification.CompanySpecification
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
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

    override fun getAllByFilter(filter: CompanyFilter): List<Company> {
      return  companyRepository.findAll(CompanySpecification.filter(filter))
    }

}