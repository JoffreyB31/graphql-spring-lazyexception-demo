package com.example.demo.dataloaders

import com.example.demo.entity.Account
import com.example.demo.service.AccountService
import java.util.concurrent.CompletableFuture
import org.dataloader.DataLoader
import org.dataloader.DataLoaderOptions
import org.springframework.stereotype.Component

@Component
class AccountDataLoader(
  private val accountService: AccountService
) : KotlinDataLoader<Long, List<Account>> {

  companion object {
    const val dataLoaderName: String = "AccountDataLoader"
  }

  override val dataLoaderName = AccountDataLoader.dataLoaderName

  override fun getDataLoader() = DataLoader<Long, List<Account>>({ ids ->
    CompletableFuture.supplyAsync {
      ids.map { accountService.findByIdIn(ids) }
    }
  }, DataLoaderOptions.newOptions().setCachingEnabled(false))

}
