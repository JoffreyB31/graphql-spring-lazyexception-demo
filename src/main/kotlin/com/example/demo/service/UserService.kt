package com.example.demo.service

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

  @Transactional(readOnly = true)
  fun findById(id: Long) = userRepository.findById(id)

  @Transactional
  fun save(user: User) = userRepository.save(user)

}
