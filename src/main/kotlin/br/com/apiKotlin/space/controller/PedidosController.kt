package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.model.Pedidos
import br.com.apiKotlin.space.request.RequestPedidoUnico
import br.com.apiKotlin.space.request.RequestPedidos
import br.com.apiKotlin.space.response.ClienteResponse
import br.com.apiKotlin.space.response.PedidoUnicoResponse
import br.com.apiKotlin.space.response.PedidosResponse
import br.com.apiKotlin.space.services.PedidosServices
import br.com.apiKotlin.space.services.VerificaColaboradorServices
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("pedidos")
class PedidosController(val pedidosServices: PedidosServices) {

    @PostMapping
    fun getPedidos(@RequestBody pedidos:RequestPedidos) : PedidosResponse {
        var pedidos = pedidosServices.getPedidos(pedidos)

        if(pedidos.isNotEmpty()) {
            return PedidosResponse(true,"Sucesso" , pedidos)
        }
        return PedidosResponse(false,"Não tem pedidos")
    }

    @PostMapping("/unico")
    fun getPedidoUnico(@RequestBody pedidoUnico:RequestPedidoUnico): PedidoUnicoResponse {
        var pedidos = pedidosServices.getPedidoUnico(pedidoUnico)

        if(pedidos.get(0).lnpCodigo!! > 0 || pedidos.get(0).llcCodigo!! > 0) {
            return PedidoUnicoResponse(false,"Pedido faturado ou com financeiro lançado" , listOf())
        }else{
            return PedidoUnicoResponse(true, "Sucesso" , pedidos)
        }
    }
}