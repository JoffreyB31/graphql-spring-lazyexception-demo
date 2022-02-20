package com.example.demo.mutations

import com.example.demo.entity.Account
import com.example.demo.entity.User
import com.example.demo.service.UserService
import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class UserMutation(private val userService: UserService) : Mutation {

  @Transactional
  fun addUser(): User {
    val account = Account("my-account-name")
    account.id = 1

    val user = User("my-username")
    user.id = 1
    user.addAccount(account)

    return userService.save(user)
  }

}
