package me.pohnrith.helloworld.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import java.math.BigDecimal

@ControllerAdvice
class ExceptionHandler() {
    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingServletRequestParameterException(ex: MissingServletRequestParameterException) : ResponseEntity<Any> {
        val message = ResponseError("Request Param[${ex.parameterName}] is missing.")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message)

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(ex: MethodArgumentTypeMismatchException) : ResponseEntity<Any> {
       val message = ResponseError("Please input [${ex.name}] as [${ex.requiredType}].")
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message)
    }
}