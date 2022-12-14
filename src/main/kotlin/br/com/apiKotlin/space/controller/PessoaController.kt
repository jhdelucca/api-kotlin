package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.model.Pessoa
import br.com.apiKotlin.space.services.PessoaServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("pessoa")
class PessoaController (val pessoaServices: PessoaServices){

    @GetMapping
    fun getAll(@RequestParam fantasia: String?) : List<Pessoa> {
        return pessoaServices.getMapping(fantasia)
    }

    @GetMapping("/{codigo}")
        fun getPessoas(@PathVariable(name = "codigo") codigo:Int): Pessoa {
            return pessoaServices.getById(codigo);
        }

    @GetMapping("/query")
        fun getPessoasQuery(): List<Pessoa> {
            return pessoaServices.getPessoa()
        }
}