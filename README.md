## Project initialized with Spring Initializr with Spring JPA
## Added dependency to graphql-kotlin-spring-server

UI at : localhost:1111/graphql

To reproduce :

Run mutation to add an entry in the db
accounts work because the lazy field is initialized before the save

```
mutation addUser { 
  addUser {
    name
    accounts {
      nickname
    }
  }
}
```

Then run this will throw : 
failed to lazily initialize a collection of role: com.example.demo.entity.User.accounts, could not initialize proxy - no Session

```
query user {
  user {
    name
    accounts {
      nickname
    }
  }
}
```

With a dataloader this works : 

```
query user {
  user {
    name
    accounts_with_dataloader {
      nickname
    }
  }
}
```
