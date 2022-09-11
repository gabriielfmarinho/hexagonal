package com.pix.web.config

import com.pix.web.resources.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.function.Consumer

@ControllerAdvice
class ControllerAdviceHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        val errors: MutableList<String> = getErrors(ex)
        val errorResponse = buildErrorResponse(errors, ex)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errorResponse)
    }

    private fun getErrors(ex: MethodArgumentNotValidException): MutableList<String> {
        val errors: MutableList<String> = mutableListOf()
        ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            error.getDefaultMessage()?.let { errors.add(it) }
        })
        return errors
    }

    private fun buildErrorResponse(errors: MutableList<String>, ex: MethodArgumentNotValidException) =
        ErrorResponse(errors = errors, code = HttpStatus.BAD_REQUEST.value(), type = ex.javaClass.simpleName )
}