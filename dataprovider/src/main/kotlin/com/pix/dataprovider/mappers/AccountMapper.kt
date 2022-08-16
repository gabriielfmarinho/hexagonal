package com.pix.dataprovider.mappers

import com.pix.core.entities.Account
import com.pix.core.entities.AccountStatus
import com.pix.core.entities.AccountType
import com.pix.core.entities.Person
import com.pix.dataprovider.entities.DynamoAccount
import com.pix.dataprovider.entities.DynamoPerson

fun Account.toDynamoAccount() = DynamoAccount(
    pk = "ACCOUNT:$number:$agency:$operation",
    sk = "DOCUMENT:${person.document}",
    number = number,
    agency = agency,
    type = type.name,
    status = status.name,
    operation = operation,
    person = DynamoPerson(person.name, person.document)
)

fun DynamoAccount.toAccount() = Account(
    number = number ?: "",
    agency = agency ?: "",
    operation = operation ?: "",
    person = Person(person!!.name!!, person!!.document!!),
)