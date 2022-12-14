package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.enun.Errors
import br.com.apiKotlin.space.exception.BadRequestException
import br.com.apiKotlin.space.exception.NotFoundException
import br.com.apiKotlin.space.model.PedidoUnico
import br.com.apiKotlin.space.model.Pedidos
import br.com.apiKotlin.space.repository.PedidoUnicoRepository
import br.com.apiKotlin.space.repository.PedidosRepository
import br.com.apiKotlin.space.request.RequestPedidoUnico
import br.com.apiKotlin.space.request.RequestPedidos
import br.com.apiKotlin.space.response.PedidoUnicoResponse
import org.springframework.stereotype.Service

@Service
class PedidosServices (val pedidosRepository: PedidosRepository , val pedidoUnicoRepository: PedidoUnicoRepository) {

    fun getPedidos(pedidos:RequestPedidos): List<Pedidos> {

        if(pedidos.vendedorCodigo > 0) {
            return pedidosRepository.getPedidosVendedor(pedidos.filial, pedidos.dataInicial,pedidos.dataFinal,
                pedidos.vendedorCodigo
            )
        }

        return pedidosRepository.getAll(pedidos.filial,pedidos.dataInicial,pedidos.dataFinal)
    }

    fun getPedidoUnico(pedidoUnico: RequestPedidoUnico): List<PedidoUnico> {

        try{
            return  pedidoUnicoRepository.getPedidoUnico(pedidoUnico.filial,pedidoUnico.serie,pedidoUnico.numero)
         }catch (e : Exception){
            throw BadRequestException(Errors.VK007.message, Errors.VK007.code)
         }
    }
}