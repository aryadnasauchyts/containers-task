package com.devops.task.containers

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CrudRepository<User, String>

@RedisHash(value = "User")
data class User(
    @Id
    @Indexed
    val id: String? = null,
    val name: String
)