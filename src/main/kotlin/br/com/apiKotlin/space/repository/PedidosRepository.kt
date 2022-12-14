package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Pedidos
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PedidosRepository: CrudRepository<Pedidos , Int> {

    @Query("Select\n" +
            "Ped_SpvCodigo,\n" +
            "Ped_Numero,\n" +
            "Ped_DtEmissao,\n" +
            "Ped_Valor,\n" +
            "Ped_pescodigo,\n" +
            "PES_RAZAO,\n" +
            "PES_FANTASIA,\n" +
            "CLB_RAZAO,\n" +
            "ped_obs,\n" +
            "Ped_FilCodigo,\n" +
            "Ped_vencodigo\n" +
            "From\n" +
            "  pedidos,\n" +
            "  pessoa,\n" +
            "  colaborador,\n" +
            "  statuspedidos\n" +
            "Where\n" +
            "  (pedidos.Ped_PesCodigo = pessoa.PES_CODIGO) And\n" +
            "  (pedidos.Ped_VenCodigo = colaborador.CLB_CODIGO) And\n" +
            "  (pedidos.Ped_StpCodigo = statuspedidos.Stp_Codigo) And\n" +
            "  (pedidos.Ped_DtEmissao >= :dataInicial) And\n" +
            "  (pedidos.Ped_DtEmissao <= :dataFinal) And\n" +
            "  (pedidos.Ped_FilCodigo = :filial) And\n" +
            "  (statuspedidos.Stp_BloqPedido = 0) And\n" +
            "  (statuspedidos.STP_CANCPEDIDO = 0)\n" +
            "Order By\n" +
            "  pedidos.Ped_Numero Desc" , nativeQuery = true)
    fun getAll(filial:Int , dataInicial:String , dataFinal:String): List<Pedidos>
    @Query("Select\n" +
            "  pedidos.Ped_SpvCodigo,\n" +
            "  pedidos.Ped_Numero,\n" +
            "  pedidos.Ped_DtEmissao,\n" +
            "  pedidos.Ped_Valor,\n" +
            "  pedidos.Ped_PesCodigo,\n" +
            "  pessoa.PES_RAZAO,\n" +
            "  pessoa.PES_FANTASIA,\n" +
            "  colaborador.CLB_RAZAO,\n" +
            "  pedidos.ped_obs,\n" +
            "  pedidos.Ped_FilCodigo,\n" +
            "  pedidos.Ped_VenCodigo\n" +
            "From\n" +
            "  pedidos,\n" +
            "  pessoa,\n" +
            "  colaborador,\n" +
            "  statuspedidos\n" +
            "Where\n" +
            "  (pedidos.Ped_PesCodigo = pessoa.PES_CODIGO) And\n" +
            "  (pedidos.Ped_VenCodigo = colaborador.CLB_CODIGO) And\n" +
            "  (pedidos.Ped_StpCodigo = statuspedidos.Stp_Codigo) And\n" +
            "  (pedidos.Ped_DtEmissao >= :dataInicial) And\n" +
            "  (pedidos.Ped_DtEmissao <= :dataFinal) And\n" +
            "  (pedidos.Ped_FilCodigo = :filial) And\n" +
            "  (pedidos.Ped_VenCodigo = :vendedorCodigo) And\n" +
            "  (statuspedidos.Stp_BloqPedido = 0) And\n" +
            "  (statuspedidos.STP_CANCPEDIDO = 0)\n" +
            "Order By\n" +
            "  pedidos.Ped_Numero Desc", nativeQuery = true)
    fun getPedidosVendedor(filial:Int , dataInicial:String , dataFinal:String, vendedorCodigo:Int): List<Pedidos>
}