package com.pix.core.usescases

import com.pix.core.dtos.CreateNewAccountDTO
import com.pix.core.entities.Account
import com.pix.core.exceptions.AccountAlreadyExistException
import com.pix.core.mappers.toAccount
import com.pix.core.ports.`in`.CreateANewAccountUseCase
import com.pix.core.ports.out.AccountRepository
import java.util.Objects.nonNull
import javax.inject.Named

@Named
class CreateANewAccountUseCaseUseCaseImpl(
    private val accountRepository: AccountRepository
) : CreateANewAccountUseCase {

    override fun execute(createNewAccountDTO: CreateNewAccountDTO) {
        val accountToCreate = createNewAccountDTO.toAccount()
        if (hasAccountWithNumberAndAgency(accountToCreate)) {
            throw AccountAlreadyExistException()
        }
        accountRepository.save(accountToCreate)
    }

    private fun hasAccountWithNumberAndAgency(account: Account): Boolean {
        return nonNull(
            accountRepository.findByAgencyAndNumberAndOperation(
                account.agency,
                account.number,
                account.operation
            )
        )
    }
}