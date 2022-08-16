package com.pix.web.resources.request

import com.pix.core.entities.AccountType
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateANewAccountRequest(

    @field:NotBlank(message = "the agency must not be blank")
    @field:Size(min = 4, max = 4, message = "the agency must contain 4 digits")
    val agency: String,

    @field:NotBlank(message = "the number must not be blank")
    @field:Size(min = 6, max = 6, message = "the number must contain 6 digits")
    val number: String,

    @field:NotBlank(message = "the operation must not be blank")
    @field:Size(min = 2, max = 2, message = "the number must contain 6 digits")
    val operation: String,

    @field:NotNull(message = "the type must not be blank")
    val type: AccountType,

    @field:Valid
    val person: CreateANewAccountPersonRequest,
)
