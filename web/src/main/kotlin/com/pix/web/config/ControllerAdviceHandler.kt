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
        val errors: MutableList<String> = mutableListOf()
        ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            error.getDefaultMessage()?.let { errors.add(it) }
        })
        val errorResponse = ErrorResponse(
            errors = errors,
            code = HttpStatus.BAD_REQUEST.value(),
            type = ex.javaClass.simpleName
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errorResponse)
    }
}