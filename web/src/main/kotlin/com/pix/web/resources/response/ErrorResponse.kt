package com.pix.web.resources.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse(
    val type: String,
    val code: Int,
    val error: String? = null,
    val errors: MutableList<String>? = null,
)
