package com.pix.core.usescases

import com.pix.core.dtos.AccountDTO
import com.pix.core.exceptions.AccountNotFoundException
import com.pix.core.mappers.toAccountDTO
import com.pix.core.ports.`in`.GetAllAccountsByDocumentUseCase
import com.pix.core.ports.out.AccountRepository
import javax.inject.Named

@Named
class GetAllAccountsByDocumentUseCaseUseCaseImpl(
    private val accountRepository: AccountRepository
) :
    GetAllAccountsByDocumentUseCase {

    override fun execute(document: String): List<AccountDTO> {
        val accounts = accountRepository.findAccountsByDocument(document)
        if (accounts.isEmpty()) {
            throw AccountNotFoundException()
        }
        return accounts
            .map { account -> account.toAccountDTO() }
    }

}