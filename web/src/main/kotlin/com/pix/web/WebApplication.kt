package com.pix.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.pix"])
class WebApplication

fun main(args: Array<String>) {
    runApplication<WebApplication>(*args)
}
