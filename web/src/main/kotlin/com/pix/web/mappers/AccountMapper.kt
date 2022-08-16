package com.pix.web.mappers

import com.pix.core.dtos.AccountDTO
import com.pix.core.dtos.CreateNewAccountDTO
import com.pix.core.dtos.CreateNewAccountPersonDTO
import com.pix.web.resources.request.CreateANewAccountPersonRequest
import com.pix.web.resources.request.CreateANewAccountRequest
import com.pix.web.resources.response.AccountResponse
import java.util.Objects.isNull

fun CreateANewAccountRequest.toCreateANewAccountDTO() = CreateNewAccountDTO(
    agency = agency,
    number = number,
    operation = operation,
    person = CreateNewAccountPersonDTO(person.name, handleDocument(person) ?: ""),
)

fun AccountDTO.toAccountResponse() =
    AccountResponse(agency = agency, number = number, operation = operation, client = client)

private fun handleDocument(person: CreateANewAccountPersonRequest): String? {
    return if (isNull(person.cpf)) {
        person.cnpj
    } else {
        person.cpf
    }
}