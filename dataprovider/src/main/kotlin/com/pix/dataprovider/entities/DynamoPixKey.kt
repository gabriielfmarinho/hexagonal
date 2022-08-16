package com.pix.dataprovider.entities

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.pix.dataprovider.consts.ACCOUNTS_BY_DOCUMENT_INDEX_NAME

@DynamoDBTable(tableName = "pix")
class DynamoPixKey(
    @DynamoDBHashKey
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = ACCOUNTS_BY_DOCUMENT_INDEX_NAME)
    var pk: String? = null,

    @DynamoDBRangeKey
    @DynamoDBIndexHashKey(globalSecondaryIndexName = ACCOUNTS_BY_DOCUMENT_INDEX_NAME)
    var sk: String? = null,

    @DynamoDBAttribute
    val type: String? = null,

    @DynamoDBAttribute
    val key: String? = null,

    @DynamoDBAttribute
    val account: String? = null,

    ) {
}