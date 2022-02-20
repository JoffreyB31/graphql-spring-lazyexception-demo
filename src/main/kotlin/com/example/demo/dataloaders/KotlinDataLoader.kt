package com.example.demo.dataloaders

import org.dataloader.DataLoader

interface KotlinDataLoader<K, V> {
  val dataLoaderName: String
  fun getDataLoader(): DataLoader<K, V>
}
