package com.kotlinbackendproject.company.repository

import com.kotlinbackendproject.company.entity.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository  : JpaRepository<Company,Long>,JpaSpecificationExecutor<Company>{
}