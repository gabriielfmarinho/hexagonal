package com.pix.dataprovider.entities

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.pix.dataprovider.consts.ACCOUNTS_BY_DOCUMENT_INDEX_NAME

@DynamoDBTable(tableName = "pix")
class DynamoAccount(

    @DynamoDBHashKey(attributeName = "pk")
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = ACCOUNTS_BY_DOCUMENT_INDEX_NAME)
    var pk: String? = null,

    @DynamoDBRangeKey(attributeName = "sk")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = ACCOUNTS_BY_DOCUMENT_INDEX_NAME)
    var sk: String? = null,

    @DynamoDBAttribute(attributeName = "agency")
    var agency: String? = null,

    @DynamoDBAttribute(attributeName = "number")
    var number: String? = null,

    @DynamoDBAttribute(attributeName = "operation")
    var operation: String? = null,

    @DynamoDBAttribute(attributeName = "status")
    var status: String? = null,

    @DynamoDBAttribute(attributeName = "type")
    var type: String? = null,

    @DynamoDBAttribute(attributeName = "person")
    var person: DynamoPerson? = null,
) {
}