package com.pix.dataprovider.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DynamoProperties {

    @Value("\${amazon.aws.dynamodb.endpoint}")
    lateinit var endpoint: String ;

    @Value("\${amazon.aws.accesskey}")
    lateinit var accessKey: String;

    @Value("\${amazon.aws.secretkey}")
    lateinit var secretKey: String;

    @Value("\${amazon.aws.region}")
    lateinit var region: String;

}