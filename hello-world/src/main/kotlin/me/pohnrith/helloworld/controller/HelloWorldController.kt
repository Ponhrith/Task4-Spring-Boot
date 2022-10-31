package me.pohnrith.helloworld.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/hello-world")
class HelloWorldController {

    @GetMapping
    fun helloWorld(@RequestParam name: String) : String {
        return "Hello $name"
    }

    @GetMapping("/{name}")
    fun helloName(@PathVariable name: String) = "Hello $name"
}
