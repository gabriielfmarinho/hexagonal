package com.pix.web.resources.request

import com.pix.core.entities.TypePixKey
import javax.validation.constraints.NotNull

data class CreateANewPixKeyRequest(

    @field:NotNull(message = "the type must not be blank")
    val type: TypePixKey,

    @field:NotNull(message = "the key must not be blank")
    val key: String,

    @field:NotNull(message = "the account must not be blank")
    val account: String,
)
