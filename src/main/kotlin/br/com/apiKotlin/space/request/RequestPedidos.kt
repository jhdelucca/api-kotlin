package br.com.apiKotlin.space.request

class RequestPedidos(val filial:Int,
                     val dataInicial: String ,
                     val dataFinal: String,
                     val vendedorCodigo : Int) {}