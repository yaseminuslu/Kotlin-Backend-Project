package com.kotlinbackendproject.company.repository

import com.kotlinbackendproject.company.entity.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface CompanyRepository  : JpaRepository<Company,Long>{
}