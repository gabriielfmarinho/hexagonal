package com.pix.dataprovider.entities

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument

@DynamoDBDocument
data class DynamoPerson(

    @DynamoDBAttribute
    var name: String? = null,

    @DynamoDBAttribute
    var document: String? = null,
)
