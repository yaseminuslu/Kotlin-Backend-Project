package com.kotlinbackendproject.employee.entity

    import com.kotlinbackendproject.company.entity.Company
    import com.kotlinbackendproject.employee.command.EmployeeUpdateCommand
    import jakarta.persistence.*

@Entity
    @Table(name = "employees")
    class Employee() {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long=1L

        @Column(name = "name",nullable = false)
        lateinit var name:String

        @Column(name = "surname",nullable = false)
        lateinit var surname:String

        @Column(name = "age",nullable = false)
        var age:Int?=null

        @Column(name = "email",nullable = false)
        lateinit var email:String

        @Column(name = "department",nullable = false)
        lateinit var department: Department

        @ManyToOne
        @JoinColumn(name = "company_id")
         lateinit var company: Company

         fun update(command: EmployeeUpdateCommand){
             command.name?.let { name=it }
             command.surname?.let { surname=it }
             command.age?.let { age=it }
             command.email?.let { email=it }
             command.department?.let { department=it }
            // command.companyId?.let { company.apply { id=it} }
         }

}