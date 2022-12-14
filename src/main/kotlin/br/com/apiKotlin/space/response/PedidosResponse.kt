package br.com.apiKotlin.space.response


import br.com.apiKotlin.space.model.Pedidos

class PedidosResponse(var resposta:Boolean , var mensagemUsuario:String, var dados: List<Pedidos>?=null) {
}