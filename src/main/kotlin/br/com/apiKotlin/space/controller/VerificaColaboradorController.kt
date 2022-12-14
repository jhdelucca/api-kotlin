package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.enun.Errors
import br.com.apiKotlin.space.exception.BadRequestException
import br.com.apiKotlin.space.exception.UnauthorizedException
import br.com.apiKotlin.space.model.Vendedor
import br.com.apiKotlin.space.response.VerificaColaboradorResponse
import br.com.apiKotlin.space.services.VerificaColaboradorServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("colaborador")
class VerificaColaboradorController(val verificaColaboradorServices: VerificaColaboradorServices) {

    @GetMapping("/{usuario}")
    fun getColaboradorCargo(@PathVariable(name = "usuario") usuario: String): VerificaColaboradorResponse {
        var colaborador = verificaColaboradorServices.getColaboradorCargo(usuario)
        if ((colaborador.genVenda == 1 || colaborador.supVenda == 1)) {
            return VerificaColaboradorResponse(true, "Usuario ${usuario} logado com sucesso", colaborador)
        } else {
            try {
                var vendedor = verificaColaboradorServices.getVendedor(usuario)
                return VerificaColaboradorResponse(true, "Usuario ${usuario} logado com sucesso", colaborador)
            } catch (ex: Exception) {
                throw UnauthorizedException(Errors.VK004.message,Errors.VK004.code);
            }
        }
    }

    @GetMapping("/{usuario}/autorizar")
    fun getColaboradorAutorizar(@PathVariable(name = "usuario") usuario: String): VerificaColaboradorResponse {

        var colaborador = verificaColaboradorServices.getColaboradorCargo(usuario)
        try {
            if ((colaborador.genVenda == 1 || colaborador.supVenda == 1)) {
                return VerificaColaboradorResponse(true, "Usuario ${usuario} logado com sucesso", colaborador)
            } else {
                return VerificaColaboradorResponse(false, "Usuario ${usuario} não é supervisor/gerente", colaborador)
            }
        } catch (ex: Exception) {
            throw UnauthorizedException(Errors.VK004.message,Errors.VK004.code);
            }

        }
    }

