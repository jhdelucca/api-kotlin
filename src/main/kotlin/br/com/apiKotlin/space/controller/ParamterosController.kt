package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.model.Parametros
import br.com.apiKotlin.space.services.ParametrosServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("parametros")
class ParamterosController(val parametrosServices: ParametrosServices) {

    @GetMapping
    fun getParametros(@RequestParam("filial") filial:Int) : Parametros {
        return parametrosServices.findParametros(filial)
    }
}