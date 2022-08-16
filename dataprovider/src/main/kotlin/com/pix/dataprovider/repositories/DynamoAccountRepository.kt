package com.pix.dataprovider.repositories

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.pix.dataprovider.consts.ACCOUNTS_BY_DOCUMENT_INDEX_NAME
import com.pix.dataprovider.entities.DynamoAccount
import org.springframework.stereotype.Repository

@Repository
open class DynamoAccountRepository(private val dynamoDBMapper: DynamoDBMapper) {

    open fun save(dynamoAccount: DynamoAccount): DynamoAccount {
        dynamoDBMapper.save(dynamoAccount)
        return dynamoAccount
    }

    open fun findAccountsByDocument(document: String): List<DynamoAccount> {
        val dynamoAccount = DynamoAccount(sk = "DOCUMENT:$document")
        val query = DynamoDBQueryExpression<DynamoAccount>()
            .withHashKeyValues(dynamoAccount)
            .withIndexName(ACCOUNTS_BY_DOCUMENT_INDEX_NAME)
            .withConsistentRead(false)
        return dynamoDBMapper.query(DynamoAccount::class.java, query)
    }

    open fun findByPk(pk: String): DynamoAccount {
        val dynamoAccount = DynamoAccount(pk = pk)
        val query = DynamoDBQueryExpression<DynamoAccount>()
            .withHashKeyValues(dynamoAccount)
            .withConsistentRead(false)
        return dynamoDBMapper.query(DynamoAccount::class.java, query).first()
    }
}