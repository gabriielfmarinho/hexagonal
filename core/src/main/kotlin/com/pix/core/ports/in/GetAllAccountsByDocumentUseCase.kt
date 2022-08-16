package com.pix.core.ports.`in`

import com.pix.core.dtos.AccountDTO
import com.pix.core.entities.Account

interface GetAllAccountsByDocumentUseCase {
    fun execute(document: String): List<AccountDTO>
}