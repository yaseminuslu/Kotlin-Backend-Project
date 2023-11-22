package com.kotlinbackendproject.entity

    import jakarta.persistence.*


    @Entity
    @Table(name = "employees")

    class Employee() {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?=null

        @Column(name = "name",nullable = false)
        lateinit var name:String

        @Column(name = "surname",nullable = false)
        lateinit var surname:String

        @Column(name = "age",nullable = false)
        var age:Int?=null

        @Column(name = "email",nullable = false)
        lateinit var email:String

        @Column(name = "department",nullable = false)
        lateinit var department:Department
}