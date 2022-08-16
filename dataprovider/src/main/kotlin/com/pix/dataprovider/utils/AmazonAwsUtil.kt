package com.pix.dataprovider.utils

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder

object AmazonAwsUtil {

    fun getEndpoint(endpoint: String, region: String): AwsClientBuilder.EndpointConfiguration {
        return AwsClientBuilder.EndpointConfiguration(endpoint, region)
    }

    fun getCredentials(accessKey: String, secretKey: String): AWSCredentialsProvider {
        return AWSStaticCredentialsProvider(
            BasicAWSCredentials(
                accessKey, secretKey
            )
        )
    }
}