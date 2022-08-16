package com.pix.core.ports.`in`

import com.pix.core.dtos.CreateNewAccountDTO

interface CreateANewAccountUseCase {

    fun execute(createNewAccountDTO: CreateNewAccountDTO)
}