package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.response.ClienteResponse
import br.com.apiKotlin.space.services.ClienteServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cliente")
class ClienteController(val clienteServices: ClienteServices) {

    @GetMapping
    fun getClientes(@RequestParam usuario:String?) : ClienteResponse {
        var cliente = clienteServices.getCLientes(usuario)

        if(cliente.isNotEmpty()) {
            return ClienteResponse(true,"SUCESSO", cliente)
        }else{
            return ClienteResponse(false,"Não existe clientes", cliente)
        }
    }
}