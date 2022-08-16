package com.pix.core.dtos

import com.pix.core.entities.AccountStatus
import com.pix.core.entities.AccountStatus.ACTIVE

data class CreateNewAccountDTO(
    val agency: String,
    val number: String,
    val operation: String,
    var status: AccountStatus = ACTIVE,
    val person: CreateNewAccountPersonDTO,
)
