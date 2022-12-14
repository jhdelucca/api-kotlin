package br.com.apiKotlin.space.response

import br.com.apiKotlin.space.model.Cliente

class ClienteResponse(var resposta:Boolean , var mensagemUsuario:String, var dados: List<Cliente>) {
}