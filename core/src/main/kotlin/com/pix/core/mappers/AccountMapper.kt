package com.pix.core.mappers

import com.pix.core.dtos.AccountDTO
import com.pix.core.dtos.CreateNewAccountDTO
import com.pix.core.entities.Account
import com.pix.core.entities.Person

fun CreateNewAccountDTO.toAccount() =
    Account(agency = agency, number = number, operation = operation, person = Person(person.name, person.document))

fun Account.toAccountDTO() = AccountDTO(
    agency = agency,
    number = number,
    operation = operation,
    client = person.name,
)