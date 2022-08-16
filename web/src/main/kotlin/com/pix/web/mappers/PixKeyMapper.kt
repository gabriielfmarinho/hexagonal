package com.pix.web.mappers

import com.pix.core.dtos.CreateANewPixKeyDTO
import com.pix.web.resources.request.CreateANewPixKeyRequest

fun CreateANewPixKeyRequest.toCreateANewPixKeyDTO () = CreateANewPixKeyDTO(
    type = type,
    key = key,
    account = account,
)