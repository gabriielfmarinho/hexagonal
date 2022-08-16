package com.pix.core.ports.out

import com.pix.core.entities.Account

interface AccountRepository {

    fun save(account: Account): Account

    fun findByAgencyAndNumberAndOperation(agency: String, number: String, operation: String): Account?

    fun findAccountsByDocument(document: String): List<Account>

    fun findByPk(pk: String): Account?
}