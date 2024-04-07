package com.devops.task.containers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContainersApplication

fun main(args: Array<String>) {
    runApplication<ContainersApplication>(*args)
}
