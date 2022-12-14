package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.model.FormaPagto
import br.com.apiKotlin.space.services.FormaPagtoServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("formapagto")
class FormaPagtoController(val formaPagtoServices: FormaPagtoServices) {

    @GetMapping
    fun findByFormaPagto(@RequestParam codigocliente:Int , @RequestParam formapagto:String) : List<FormaPagto>{
        return formaPagtoServices.findByFormaPagto(codigocliente,formapagto)
    }
}