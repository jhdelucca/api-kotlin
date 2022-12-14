package br.com.apiKotlin.space.response

import br.com.apiKotlin.space.model.Cliente
import br.com.apiKotlin.space.model.Produto
import br.com.apiKotlin.space.model.UnidadePro

class UnidadeProResponse(var resposta:Boolean, var mensagemUsuario:String, var dados: List<UnidadePro>) {
}