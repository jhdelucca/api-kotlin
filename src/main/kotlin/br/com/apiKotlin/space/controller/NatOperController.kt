package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.model.NatOper
import br.com.apiKotlin.space.services.NatOperServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("natoper")
class NatOperController(val natOperServices: NatOperServices) {

    @GetMapping
    fun findByNatOper(@RequestParam filial:Int , @RequestParam natureza:String):List<NatOper>{
        return natOperServices.findByNatOper(filial,natureza)
    }
}