package com.pix.core.dtos

import com.pix.core.entities.TypePixKey

data class CreateANewPixKeyDTO(
    val type: TypePixKey,
    val key: String,
    val account: String,
)
