package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.UnidadePro
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UnidadeProRepository:CrudRepository<UnidadePro,Int> {

    @Query("Select\n" +
            "              pro_codigo,\n" +
            "              pro_desc,\n" +
            "              unp_unidade,\n" +
            "              unp_quantidade,\n" +
            "              unp_fatestoque,\n" +
            "              unp_fatvenda,\n" +
            "              round(((Select Sum(localprod.LPD_ESTFISICO) From localprod, localfilial\n" +
            "              Where (localprod.LPD_FILCODIGO = localfilial.LCF_FILCODIGO) And\n" +
            "                (localprod.LPD_LCECODIGO = localfilial.LCF_LCECODIGO) And\n" +
            "                (localprod.LPD_PROCODIGO = produto.pro_codigo) And\n" +
            "                (localprod.LPD_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "                (localfilial.lcf_permiteven = 1)) - (produtofilial.pfi_estpenentre +\n" +
            "              produtofilial.pfi_estpenconfi)) / unidadepro.unp_fatestoque, 2) As estdisp,\n" +
            "              (produtopreco.PPR_PRECOVENDA * unidadepro.unp_fatvenda *\n" +
            "              unidadepro.unp_fatestoque) As precounp\n" +
            "            From\n" +
            "              produto,\n" +
            "              unidadepro,\n" +
            "              produtofilial,\n" +
            "              produtopreco,\n" +
            "              tabpreco,\n" +
            "              parametrovap\n" +
            "            Where\n" +
            "              (produto.pro_codigo = unidadepro.unp_procodigo) And\n" +
            "              (produto.pro_codigo = produtofilial.PFI_PROCODIGO) And\n" +
            "              (produtofilial.PFI_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "              (tabpreco.TPR_CODIGO = parametrovap.PAP_TPRCODIGO) And\n" +
            "              (produto.pro_codigo = produtopreco.PPR_PROCODIGO) And\n" +
            "              (produtopreco.PPR_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "              (produtopreco.PPR_PRBCODIGO = tabpreco.TPR_PRBCODIGO) And\n" +
            "              (produto.pro_codigo = :codigoproduto) And\n" +
            "              (unidadepro.unp_ativo = 1) And\n" +
            "              (produtofilial.pfi_libvenda = 1) And\n" +
            "              (unidadepro.unp_libvenda = 1) And\n" +
            "              (produtofilial.pfi_inativo = 0) And\n" +
            "              (parametrovap.PAP_FILCODIGO = :filial)\n" +
            "            Order By\n" +
            "              pro_desc,\n" +
            "              unp_padvenda Desc" , nativeQuery = true)
    fun getUnidadeProduto(filial: Int , codigoproduto:Int) : List<UnidadePro>

    @Query("Select\n" +
            "  produto.pro_codigo,\n" +
            "  produto.pro_desc,\n" +
            "  unidadepro.unp_unidade,\n" +
            "  unidadepro.unp_quantidade,\n" +
            "  unidadepro.unp_fatestoque,\n" +
            "  unidadepro.unp_fatvenda,\n" +
            "  Round(produtopreco.PPR_PRECOVENDA * unidadepro.unp_fatvenda *\n" +
            "  unidadepro.unp_fatestoque, 2) As precounp,\n" +
            "  round(((Select Sum(localprod.LPD_ESTFISICO) From localprod, localfilial\n" +
            "  Where (localprod.LPD_FILCODIGO = localfilial.LCF_FILCODIGO) And\n" +
            "    (localprod.LPD_LCECODIGO = localfilial.LCF_LCECODIGO) And\n" +
            "    (localprod.LPD_PROCODIGO = produto.pro_codigo) And\n" +
            "    (localprod.LPD_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "    (localfilial.lcf_permiteven = 1)) - (produtofilial.pfi_estpenentre +\n" +
            "  produtofilial.pfi_estpenconfi)) / unidadepro.unp_fatestoque, 2) As estdisp\n" +
            "\n" +
            "From\n" +
            "  produto,\n" +
            "  unidadepro,\n" +
            "  parametrovap,\n" +
            "  tabpreco,\n" +
            "  produtofilial,\n" +
            "  produtopreco\n" +
            "Where\n" +
            "  (produto.pro_codigo = unidadepro.unp_procodigo) And\n" +
            "  (produto.pro_codigo = produtofilial.PFI_PROCODIGO) And\n" +
            "  (produtofilial.PFI_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "  (tabpreco.TPR_CODIGO = parametrovap.PAP_TPRCODIGO) And\n" +
            "  (produto.pro_codigo = produtopreco.PPR_PROCODIGO) And\n" +
            "  (produtopreco.PPR_FILCODIGO = parametrovap.PAP_FILCODIGO) And\n" +
            "  (produtopreco.PPR_PRBCODIGO = tabpreco.TPR_PRBCODIGO) And\n" +
            "  (produto.pro_codigo = :codigoProduto) And\n" +
            "  (unidadepro.unp_unidade = :unidade) And\n" +
            "  (unidadepro.unp_quantidade = :undquant) And\n" +
            "  (unidadepro.unp_ativo = 1) And\n" +
            "  (parametrovap.PAP_FILCODIGO = :filial) And\n" +
            "  (produtofilial.pfi_libvenda = 1) And\n" +
            "  (unidadepro.unp_libvenda = 1) And\n" +
            "  (produtofilial.pfi_inativo = 0)\n" +
            "Order By\n" +
            "  produto.pro_desc,\n" +
            "  unidadepro.unp_padvenda Desc" , nativeQuery = true)
    fun getUnidadeProdutoCodigo(filial:Int, codigoProduto:Int, unidade:String, undquant:Int) : List<UnidadePro>
}