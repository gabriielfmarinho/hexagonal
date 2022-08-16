package com.pix.core.ports.`in`

import com.pix.core.dtos.CreateANewPixKeyDTO

interface CreateANewPixKeyUseCase {

    fun execute(createANewPixKeyDTO: CreateANewPixKeyDTO)
}