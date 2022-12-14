package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.model.CondPagto
import br.com.apiKotlin.space.services.CondPagtoServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity

@RestController
@RequestMapping("condpagto")
class CondPagtoController(val condPagtoServices: CondPagtoServices) {

    @GetMapping
    fun findByCondPagto(@RequestParam codigocliente:Int , @RequestParam condpagto:Int) : List<CondPagto>{
        return condPagtoServices.findByCondPagto(codigocliente,condpagto)
    }

}