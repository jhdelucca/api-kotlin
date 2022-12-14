package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Produto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ProdutosRepository:CrudRepository<Produto,Int> {

    @Query("Select\n" +
            "pro_codigo ,\n" +
            "pro_desc ,\n" +
            "pro_grpcodigo ,\n" +
            "pro_sgpcodigo ,\n" +
            "unp_unidade ,\n" +
            "unp_quantidade ,\n" +
            "unp_descemb ,\n" +
            "unp_fatestoque ,\n" +
            "unp_fatvenda ,\n" +
            "ppr_precovenda ,\n" +
            "Cbp_Codigo ,\n" +
            "  (Select Sum(localprod.LPD_ESTFISICO) From localprod, localfilial\n" +
            "  Where (localprod.LPD_FILCODIGO = localfilial.LCF_FILCODIGO) And\n" +
            "    (localprod.LPD_LCECODIGO = localfilial.LCF_LCECODIGO) And\n" +
            "    (localprod.LPD_PROCODIGO = produto.pro_codigo) And\n" +
            "    (localprod.LPD_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "    (localfilial.lcf_permiteven = 1)) - (produtofilial.pfi_estpenentre +\n" +
            "  produtofilial.pfi_estpenconfi) As estdisp,\n" +
            "  produto.pro_referencia As referencia,\n" +
            "pro_grvcodigo,\n" +
            "grv_exclusivo \n" +
            "From\n" +
            "  grupopro,\n" +
            "  subgrupopro,\n" +
            "  unidadepro,\n" +
            "  produtofilial,\n" +
            "  produtopreco,\n" +
            "  tabpreco,\n" +
            "  parametrovap,\n" +
            "  produto\n" +
            "  Left Join\n" +
            "  codbarraspro On produto.pro_codigo = codbarraspro.Cbp_ProCodigo\n" +
            "  Left Join\n" +
            "  grupovenda On produto.pro_grvcodigo = grupovenda.grv_codigo\n" +
            "Where\n" +
            "  (produto.pro_grpcodigo = grupopro.GRP_CODIGO) And\n" +
            "  (produto.pro_sgpcodigo = subgrupopro.Sgp_Codigo) And\n" +
            "  (produto.pro_codigo = unidadepro.unp_procodigo) And\n" +
            "  (produto.pro_codigo = produtofilial.PFI_PROCODIGO) And\n" +
            "  (produtofilial.PFI_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "  (tabpreco.TPR_CODIGO = parametrovap.PAP_TPRCODIGO) And\n" +
            "  (produto.pro_codigo = produtopreco.PPR_PROCODIGO) And\n" +
            "  (produtopreco.PPR_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "  (produtopreco.PPR_PRBCODIGO = tabpreco.TPR_PRBCODIGO) And\n" +
            "  (unidadepro.unp_padvenda = 1) And\n" +
            "  (parametrovap.PAP_FILCODIGO = :filial) And\n" +
            "  (produto.pro_ativo = 1) And\n" +
            "  (produto.pro_nenviapalm = 0) And\n" +
            "  (produtofilial.pfi_inativo = 0)\n" +
            "Order By\n" +
            "produto.pro_desc",nativeQuery = true)
    fun findProdutos(filial:Int):List<Produto>

}