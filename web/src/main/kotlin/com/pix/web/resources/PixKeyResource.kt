package com.pix.web.resources

import com.pix.core.ports.`in`.CreateANewPixKeyUseCase
import com.pix.web.mappers.toCreateANewPixKeyDTO
import com.pix.web.resources.request.CreateANewPixKeyRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pixkeys")
class PixKeyResource(private val createANewPixKeyUseCase: CreateANewPixKeyUseCase) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createANewPixKey(@RequestBody createANewPixKeyRequest: CreateANewPixKeyRequest) {
        createANewPixKeyUseCase.execute(createANewPixKeyRequest.toCreateANewPixKeyDTO())
    }
}