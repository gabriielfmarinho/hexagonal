package com.pix.core.usescases

import com.pix.core.dtos.CreateANewPixKeyDTO
import com.pix.core.exceptions.AccountNotFoundException
import com.pix.core.mappers.toPixKey
import com.pix.core.ports.`in`.CreateANewPixKeyUseCase
import com.pix.core.ports.out.AccountRepository
import com.pix.core.ports.out.PixKeyRepository
import java.util.Objects.isNull
import javax.inject.Named

@Named
class CreateANewPixKeyUseCaseImpl(
    private val pixKeyRepository: PixKeyRepository,
    private val accountRepository: AccountRepository,
) : CreateANewPixKeyUseCase {

    override fun execute(createANewPixKeyDTO: CreateANewPixKeyDTO) {
        val account = accountRepository.findByPk(createANewPixKeyDTO.account)
        if (isNull(account)) {
            throw AccountNotFoundException()
        }
        pixKeyRepository.save(createANewPixKeyDTO.toPixKey())
    }
}