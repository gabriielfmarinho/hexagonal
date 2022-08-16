package com.pix.web.resources

import com.pix.core.ports.`in`.CreateANewAccountUseCase
import com.pix.core.ports.`in`.GetAllAccountsByDocumentUseCase
import com.pix.web.mappers.toAccountResponse
import com.pix.web.mappers.toCreateANewAccountDTO
import com.pix.web.resources.request.CreateANewAccountRequest
import com.pix.web.resources.response.AccountResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/accounts")
class AccountResource(
    private val createANewAccountUseCase: CreateANewAccountUseCase,
    private val getAllAccountsByDocumentUseCase: GetAllAccountsByDocumentUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createANewAccount(@RequestBody @Valid createANewAccountRequest: CreateANewAccountRequest) {
        createANewAccountUseCase.execute(createANewAccountRequest.toCreateANewAccountDTO())
    }

    @GetMapping("/{document}")
    fun getAllAccountByDocument(@PathVariable document: String): ResponseEntity<List<AccountResponse>> {
        val accounts = getAllAccountsByDocumentUseCase.execute(document)
        return ResponseEntity.ok(accounts.map { account -> account.toAccountResponse() });
    }
}