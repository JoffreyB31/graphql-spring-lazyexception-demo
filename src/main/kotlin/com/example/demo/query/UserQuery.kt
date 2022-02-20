package com.example.demo.query

import com.example.demo.entity.User
import com.example.demo.service.AccountService
import com.example.demo.service.UserService
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class UserQuery(private val userService: UserService) : Query {

  @Transactional
  fun user(): User = userService.findById(1).orElseThrow()

}
