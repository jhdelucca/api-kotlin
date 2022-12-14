package br.com.apiKotlin.space.exception

import br.com.apiKotlin.space.response.ErroResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(ex:Exception , request:WebRequest): ResponseEntity<ErroResponse> {
       val erro = ErroResponse(
            400,
            "Erro! Verifique se os dados estão corretos.",
            "0001",
            null
        )

        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handlerNotFoundException(ex:NotFoundException,request: WebRequest):ResponseEntity<ErroResponse>{
        val erro = ErroResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)   }

    @ExceptionHandler(BadRequestException::class)
    fun handlerBadRequestException(ex:BadRequestException,request: WebRequest):ResponseEntity<ErroResponse>{
        val erro = ErroResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)   }

    @ExceptionHandler(UnauthorizedException::class)
    fun handleException(ex:UnauthorizedException , request:WebRequest): ResponseEntity<ErroResponse> {
        val erro = ErroResponse(
            HttpStatus.UNAUTHORIZED.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(erro, HttpStatus.UNAUTHORIZED)
    }
}