package com.devops.task.containers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers() = userService.findAllUsers()

    @PostMapping
    fun addUser(@RequestBody user: User) {
        userService.addUser(user)
    }

}