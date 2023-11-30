package com.kotlinbackendproject.employee.specification

import com.kotlinbackendproject.company.entity.Company
import com.kotlinbackendproject.employee.entity.Department
import com.kotlinbackendproject.employee.entity.Employee
import org.springframework.data.jpa.domain.Specification
import jakarta.persistence.criteria.Predicate

data class EmployeeFilter(
        var id:Long?,
        var name:String?,
        var surname:String?,
        var age:Int?,
        var email:String?,
        var department: Department?,
        var companyId:Long?,
        var minAge:Int?,
        var maxAge:Int?
)
class EmployeeSpecification {
    companion object {
        fun filter(filter: EmployeeFilter): Specification<Employee> {
            return Specification { root, query, criteriaBuilder ->
                val predicates= mutableListOf<Predicate>()

                filter.id?.let {
                    predicates.add(criteriaBuilder.equal(root.get<Long>("id"), it))
                }
                filter.name?.let {
                    predicates.add(
                            criteriaBuilder.like(root.get("name"), it)
                    )
                }
                filter.surname?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<String>("surname"),it))
                }
                filter.minAge?.let {minAge->
                    filter.maxAge?.let {maxAge->
                        predicates.add(
                                criteriaBuilder.between(root.get<Int>("age"),minAge,maxAge)
                        )
                    }
                }
                filter.age?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<Int>("age"),it)
                    )
                }
                filter.department?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<Department>("department"),it)
                    )
                }
                filter.email?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<String>("email"),it)
                    )
                }
                filter.companyId?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<Company>("company").get<Long>("id"),it)
                    )
                }
                criteriaBuilder.and(*predicates.toTypedArray())
            }
        }
    }
}

