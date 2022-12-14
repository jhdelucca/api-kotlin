package br.com.apiKotlin.space.response

import br.com.apiKotlin.space.model.Cliente
import br.com.apiKotlin.space.model.Produto

class ProdutosResponse(var resposta:Boolean , var mensagemUsuario:String, var dados: List<Produto>) {
}