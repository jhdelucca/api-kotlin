package br.com.apiKotlin.space.response

import br.com.apiKotlin.space.model.ColaboradorCargo
import br.com.apiKotlin.space.model.Vendedor

data class VerificaColaboradorResponse(var resposta:Boolean, var mensagemUsuario:String , var dados: ColaboradorCargo? = null ) {
}