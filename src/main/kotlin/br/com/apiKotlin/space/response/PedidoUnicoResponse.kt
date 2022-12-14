package br.com.apiKotlin.space.response

import br.com.apiKotlin.space.model.PedidoUnico
import br.com.apiKotlin.space.model.Pedidos

class PedidoUnicoResponse(var resposta:Boolean , var mensagemUsuario:String, var dados: List<PedidoUnico>?=null) {
}