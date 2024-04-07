package com.devops.task.containers

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun findAllUsers() = userRepository.findAll().toList()

    fun addUser(user: User) = userRepository.save(user)
}