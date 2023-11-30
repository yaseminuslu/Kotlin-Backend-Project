package com.kotlinbackendproject.company.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "companies")
class Company() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     var id:Long?=null

    @Column(name = "companyName")
    lateinit var name:String

    @Column(name = "companyAddress")
    lateinit var address:String

    @Column(name = "companyDate")
     var date:LocalDateTime=LocalDateTime.now()
}