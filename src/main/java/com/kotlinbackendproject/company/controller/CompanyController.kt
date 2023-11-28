package com.kotlinbackendproject.company.controller

import com.kotlinbackendproject.company.entity.Company
import com.kotlinbackendproject.company.service.CompanyService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/companies")

class CompanyController (private val companyService: CompanyService) {

    @GetMapping("/{id}")
    fun getByCompanyId(@PathVariable id:Long):Company{
        return companyService.getByCompanyId(id)
    }
    @GetMapping
    fun getAllCompany():List<Company>{
        return companyService.getAllCompany()
    }
    @PostMapping
    fun createCompany(@RequestBody company:Company):Company{
        return companyService.createCompany(company)
    }
    @PutMapping("/{id}")
    fun updateCompany(@PathVariable id:Long, @RequestBody company: Company):Company{
        return companyService.updateCompany(id, company)
    }
    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id:Long){
      return  companyService.deleteCompany(id)
    }

    @GetMapping("/asc")
    fun getCompanyIdASC():List<Company>{
        return companyService.getCompanyIdASC()
    }

    @GetMapping("/desc")
    fun getCompanyIdDESC():List<Company>{
        return companyService.getCompanyIdDESC()
    }

}