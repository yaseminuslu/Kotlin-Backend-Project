package com.kotlinbackendproject.company.specification

import com.kotlinbackendproject.company.entity.Company
import jakarta.persistence.criteria.Predicate
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDateTime

data class CompanyFilter(
        var id:Long?,
        var name:String?,
        var address:String?,
        var date:LocalDateTime?,
        var minDate:LocalDateTime?,
        var maxDate:LocalDateTime?
)
class CompanySpecification {
    companion object{
        fun filter(filter:CompanyFilter):Specification<Company>{
            return Specification{root, query, criteriaBuilder ->
                val predicates = mutableListOf<Predicate>()

                filter.id?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<Long>("id"),it)
                    )
                }
                filter.name?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<String>("name"),it)
                    )
                }
                filter.address?.let {
                    predicates.add(
                            criteriaBuilder.equal(root.get<String>("address"),it)
                    )
                }
                filter.minDate?.let { minDate->
                    filter.maxDate?.let { maxDate->
                        predicates.add(
                                criteriaBuilder.between(root.get<LocalDateTime>("date"),minDate,maxDate)
                        )
                    }
                }
                criteriaBuilder.and(*predicates.toTypedArray())
            }
        }
    }
}