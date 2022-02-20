package com.example.demo.entity

import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "test_accounts")
data class Account(

  var nickname: String? = null

) {

  @Id
  @GraphQLIgnore
  var id: Long = 0

  @GraphQLIgnore
  @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  @JoinColumn(name = "userId", updatable = true, insertable = true)
  var user: User? = null


}
