package com.pix.web.resources.response

data class AccountResponse(
    val agency: String,
    val number: String,
    val operation: String,
    val client: String,
)
