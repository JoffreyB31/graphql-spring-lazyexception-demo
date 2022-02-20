package com.example.demo.repository

import com.example.demo.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {

  fun findByIdIn(ids: List<Long>): List<Account>

}
