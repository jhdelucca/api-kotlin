package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.model.Filial
import br.com.apiKotlin.space.services.FilialServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("filial")
class FilialController(val filialServices: FilialServices) {

    @GetMapping("/{usuario}")
    fun getFiliaisUsr(@PathVariable(name="usuario") usuario:String) : List<Filial> {
     return filialServices.getFiliaisUsuario(usuario)
    }

    @GetMapping
    fun getFiliais() : List<Filial> {
        return filialServices.getFiliais()
    }
}