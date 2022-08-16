package com.pix.dataprovider.repositories

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.pix.dataprovider.entities.DynamoAccount
import com.pix.dataprovider.entities.DynamoPixKey
import org.springframework.stereotype.Repository


@Repository
open class DynamoPixKeyRepository(private val dynamoDBMapper: DynamoDBMapper) {

    open fun save(dynamoPixKey: DynamoPixKey): DynamoPixKey {
        dynamoDBMapper.save(dynamoPixKey)
        return dynamoPixKey
    }
}