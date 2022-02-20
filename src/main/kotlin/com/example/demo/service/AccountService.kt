package com.example.demo.service

import com.example.demo.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(private val accountRepository: AccountRepository) {

  @Transactional(readOnly = true)
  fun findByIdIn(ids: List<Long>) = accountRepository.findByIdIn(ids)

}
