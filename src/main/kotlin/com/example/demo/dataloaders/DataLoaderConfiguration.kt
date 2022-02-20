package com.example.demo.dataloaders

import com.expediagroup.graphql.server.execution.DataLoaderRegistryFactory
import org.dataloader.DataLoaderRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoaderConfiguration {

  @Bean
  fun dataLoaderRegistryFactory(accountDataLoader: AccountDataLoader): DataLoaderRegistryFactory {
    return object : DataLoaderRegistryFactory {
      override fun generate(): DataLoaderRegistry {
        val registry = DataLoaderRegistry()

        registry.register(accountDataLoader.dataLoaderName, accountDataLoader.getDataLoader())

        return registry
      }
    }
  }

}
