package com.pix.core.mappers

import com.pix.core.dtos.CreateANewPixKeyDTO
import com.pix.core.entities.PixKey

fun CreateANewPixKeyDTO.toPixKey () = PixKey(
    type = type,
    key = key,
    account = account,
)