package com.pix.dataprovider.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.pix.dataprovider.properties.DynamoProperties
import com.pix.dataprovider.utils.AmazonAwsUtil.getCredentials
import com.pix.dataprovider.utils.AmazonAwsUtil.getEndpoint
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackages = ["com.pix.dataprovider.repositories"])
open class DynamoDBConfig(private val dynamoProperties: DynamoProperties) {

    @Bean
    open fun amazonDynamoDB(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder
            .standard()
            .withEndpointConfiguration(getEndpoint(dynamoProperties.endpoint, dynamoProperties.region))
            .withCredentials(getCredentials(dynamoProperties.accessKey, dynamoProperties.secretKey))
            .build()
    }
}