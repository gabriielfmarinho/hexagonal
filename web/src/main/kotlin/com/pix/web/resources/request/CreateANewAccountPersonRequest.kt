package com.pix.web.resources.request

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class CreateANewAccountPersonRequest(

    @field:NotBlank(message = "the name must not be blank")
    @field:Size(max = 100, message = "the name must be maximum of 100 characters")
    val name: String,

    @field:Pattern(
        regexp = "^((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))*\$",
        message = "the cpf must be to the pattern { 000.000.000-00 }"
    )
    @Schema(example = "000.000.000-00")
    val cpf: String? = null,

    @field:Pattern(
        regexp = "^((\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2}))*\$",
        message = "the cnpj must be to the pattern { 00.000.000/0001-00 }"
    )
    val cnpj: String? = null,
)