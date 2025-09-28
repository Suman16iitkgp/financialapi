package com.suman.financialapi.repository

import com.suman.financialapi.dto.Deal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DealRepository : JpaRepository<Deal, Long> {
}