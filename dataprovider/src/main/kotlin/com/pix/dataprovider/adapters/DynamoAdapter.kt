package com.pix.dataprovider.adapters

import com.pix.core.entities.Account
import com.pix.core.entities.PixKey
import com.pix.core.ports.out.AccountRepository
import com.pix.core.ports.out.PixKeyRepository
import com.pix.dataprovider.annotations.Adapter
import com.pix.dataprovider.mappers.toAccount
import com.pix.dataprovider.mappers.toDynamoAccount
import com.pix.dataprovider.mappers.toDynamoPixKey
import com.pix.dataprovider.mappers.toPixKey
import com.pix.dataprovider.repositories.DynamoAccountRepository
import com.pix.dataprovider.repositories.DynamoPixKeyRepository

@Adapter
class DynamoAdapter(
    private val dynamoAccountRepository: DynamoAccountRepository,
    private val dynamoPixKeyRepository: DynamoPixKeyRepository
) : AccountRepository, PixKeyRepository {

    override fun save(account: Account): Account {
        val accountSaved = dynamoAccountRepository.save(account.toDynamoAccount())
        return accountSaved.toAccount();
    }

    override fun findByAgencyAndNumberAndOperation(agency: String, number: String, operation: String): Account? {
        return null
    }

    override fun findAccountsByDocument(document: String): List<Account> {
        val dynamoAccounts = dynamoAccountRepository.findAccountsByDocument(document)
        return dynamoAccounts
            .map { dynamoAccount -> dynamoAccount.toAccount() }
    }

    override fun findByPk(pk: String): Account {
        val dynamoAccount = dynamoAccountRepository.findByPk(pk)
        return dynamoAccount.toAccount()
    }

    override fun save(pixKey: PixKey): PixKey{
        val pixKeySaved = dynamoPixKeyRepository.save(pixKey.toDynamoPixKey())
        return pixKeySaved.toPixKey()
    }

}