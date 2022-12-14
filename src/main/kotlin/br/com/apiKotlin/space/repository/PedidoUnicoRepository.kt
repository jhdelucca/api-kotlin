package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.PedidoUnico
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PedidoUnicoRepository:CrudRepository<PedidoUnico,Int> {
    @Query("Select\n" +
            "  ped_codorigem, \n" +
            "  ped_filcodigo,\n" +
            "  ped_spvcodigo,\n" +
            "  ped_numero,\n" +
            "  ped_lnpcodigo,\n" +
            "  ped_llccodigo,\n" +
            "  ipv_procodigo,\n" +
            "  pro_desc,\n" +
            "  ipv_unpunidade,\n" +
            "  ipv_unpquant,\n" +
            "  ipv_quantidade,\n" +
            "  ipv_precovenda,\n" +
            "  ped_pescodigo,\n" +
            "  PES_RAZAO,\n" +
            "  PES_FANTASIA,\n" +
            "  ped_vencodigo,\n" +
            "  CLB_RAZAO,\n" +
            "  ped_natcodigo,\n" +
            "  nat_desc,\n" +
            "  ped_fpgcodigo,\n" +
            "  FPG_DESC,\n" +
            "  ped_cpgcodigo,\n" +
            "  CPG_DESC,\n" +
            "  ped_obs,\n" +
            "  ped_dtemissao,\n" +
            "  round((produtopreco.PPR_PRECOVENDA * unidadepro.unp_fatvenda *\n" +
            "  unidadepro.unp_fatestoque), 2) As precotabela,\n" +
            "  ped_valor\n" +
            "From\n" +
            "  pedidos,\n" +
            "  itenspedido,\n" +
            "  produto,\n" +
            "  pessoa,\n" +
            "  natoper,\n" +
            "  colaborador,\n" +
            "  formapagto,\n" +
            "  condpagto,\n" +
            "  produtopreco,\n" +
            "  unidadepro,\n" +
            "  tabpreco\n" +
            "Where\n" +
            "  (pedidos.ped_Filcodigo = itenspedido.Ipv_Filcodigo) And\n" +
            "  (pedidos.ped_Spvcodigo = itenspedido.Ipv_Spvcodigo) And\n" +
            "  (pedidos.ped_Numero = itenspedido.Ipv_pedNumero) And\n" +
            "  (itenspedido.Ipv_Procodigo = produto.pro_codigo) And\n" +
            "  (pedidos.ped_Pescodigo = pessoa.PES_codigo) And\n" +
            "  (pedidos.ped_Natcodigo = natoper.Nat_codigo) And\n" +
            "  (pedidos.ped_Fpgcodigo = formapagto.FPG_codigo) And\n" +
            "  (pedidos.ped_Cpgcodigo = condpagto.CPG_codigo) And\n" +
            "  (pedidos.ped_Vencodigo = colaborador.CLB_codigo) And\n" +
            "  (itenspedido.Ipv_Procodigo = unidadepro.unp_procodigo) And\n" +
            "  (itenspedido.Ipv_UnpUnidade = unidadepro.unp_unidade) And\n" +
            "  (itenspedido.Ipv_UnpQuant = unidadepro.unp_quantidade) And\n" +
            "  (produtopreco.PPR_PROcodigo = itenspedido.Ipv_Procodigo) And\n" +
            "  (itenspedido.Ipv_Filcodigo = produtopreco.PPR_FILcodigo) And\n" +
            "  (pedidos.ped_Tprcodigo = tabpreco.TPR_codigo) And\n" +
            "  (produtopreco.PPR_PRBcodigo = tabpreco.TPR_PRBcodigo) And\n" +
            "  (pedidos.ped_filcodigo = :filial) And\n" +
            "  (pedidos.ped_spvcodigo = :serie) And\n" +
            "  (pedidos.ped_numero = :numero)" , nativeQuery = true)
    fun getPedidoUnico(filial:Int, serie:String, numero:Int) : List<PedidoUnico>
}