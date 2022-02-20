package com.example.demo.entity

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.server.extensions.getValueFromDataLoader
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "test_users")
data class User(

  @Column(nullable = false)
  val name: String

) {

  @Id
  @GraphQLIgnore
  var id: Long = 0

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  var accounts: List<Account> = mutableListOf()

  @GraphQLIgnore
  fun addAccount(account: Account) {
    account.user = this
    accounts = listOf(account)
  }

  @GraphQLName("accounts_with_dataloader")
  @GraphQLDescription("Get the accounts friends using data loader")
  fun getAccountsWithDataloader(dataFetchingEnvironment: DataFetchingEnvironment): CompletableFuture<List<Account>> {
    return dataFetchingEnvironment.getValueFromDataLoader("AccountDataLoader", id)
  }

}
