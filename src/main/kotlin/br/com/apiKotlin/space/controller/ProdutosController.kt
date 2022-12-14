package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.request.RequestUnidadePro
import br.com.apiKotlin.space.response.ProdutosResponse
import br.com.apiKotlin.space.response.UnidadeProResponse
import br.com.apiKotlin.space.services.ProdutosService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("produtos")
class ProdutosController(val produtosService: ProdutosService) {

    @GetMapping
    fun getProdutos(@RequestParam filial:Int) : ProdutosResponse {
        val produtos = produtosService.getProdutos(filial)

        if(produtos.isEmpty()) {
            return ProdutosResponse(false,"Não existe produtos", produtos)
        }
        return ProdutosResponse(true,"SUCESSO" , produtos)
    }

    @PostMapping("/unidade")
    fun getUnidadePro(@RequestBody requestUnidadePro:RequestUnidadePro) : UnidadeProResponse {
        val dados = produtosService.getUnidadePro(requestUnidadePro)

        if(dados.isEmpty()) {
            return UnidadeProResponse(false, "Nenhuma Unidade Encontrada" , dados)
        }

        return UnidadeProResponse(true, "SUCESSO" , dados)
    }
}