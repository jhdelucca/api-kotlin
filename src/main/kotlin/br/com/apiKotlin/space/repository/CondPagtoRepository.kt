package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.CondPagto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CondPagtoRepository : CrudRepository<CondPagto,Int>{

    @Query(value = "select cpg_codigo, cpg_desc from condpgpessoa,condpagto where\n" +
            "cpg_codigo = cpe_cpgcodigo and cpg_ativo = 1 and cpe_pescodigo= :codigo", nativeQuery = true)
    fun findByCondPagtoCliente(codigo : Int) : List<CondPagto>

    @Query(value = "select cpg_codigo,cpg_desc from condpagto where cpg_ativo = 1 and cpg_nenvpalm = 0", nativeQuery = true)
    fun findByCondPagto(): List<CondPagto>

    /** Maker **/

    @Query(value = "Select\n" +
            "  CPG_CODIGO ,\n" +
            "  CPG_DESC \n" +
            "From\n" +
            "  condpagto,\n" +
            "  cliente\n" +
            "Where\n" +
            "  (cliente.CLI_CPGCODIGO = condpagto.CPG_CODIGO) And\n" +
            "  (cliente.CLI_PESCODIGO = :cliente) And\n" +
            "  (condpagto.CPG_ATIVO = 1) And\n" +
            "  (condpagto.cpg_nenvpalm = 0)\n" +
            "union\n" +
            "Select\n" +
            "  CPG_CODIGO,\n" +
            "  CPG_DESC \n" +
            "From\n" +
            "  condpagto,\n" +
            "  condpgpessoa,\n" +
            "  cliente\n" +
            "Where\n" +
            "  (condpgpessoa.CPE_CPGCODIGO = condpagto.CPG_CODIGO) And\n" +
            "  (condpgpessoa.CPE_PESCODIGO = cliente.CLI_PESCODIGO) And\n" +
            "  (condpgpessoa.CPE_CPGCODIGO <> cliente.CLI_CPGCODIGO) And\n" +
            "  (condpgpessoa.CPE_PESCODIGO = :cliente) And\n" +
            "  (condpagto.CPG_ATIVO = 1) And\n" +
            "  (condpagto.cpg_nenvpalm = 0)" , nativeQuery = true)
    fun findCondicaoCliente(cliente:Int) : List<CondPagto>

    @Query(value = "Select\n" +
            " CPG_CODIGO ,\n" +
            " CPG_DESC\n" +
            "From\n" +
            "  condpagto,\n" +
            "  cliente\n" +
            "Where\n" +
            "  (cliente.CLI_CPGCODIGO = condpagto.CPG_CODIGO) And\n" +
            "  (cliente.CLI_PESCODIGO = :cliente) And\n" +
            "  (condpagto.CPG_ATIVO = 1) And\n" +
            "  (condpagto.cpg_nenvpalm = 0)\n" +
            "union\n" +
            "Select\n" +
            "  CPG_CODIGO,\n" +
            "  CPG_DESC\n" +
            "From\n" +
            "  condpagto,\n" +
            "  cliente\n" +
            "Where\n" +
            "  (condpagto.CPG_CODIGO <> cliente.CLI_CPGCODIGO) And\n" +
            "  (cliente.CLI_PESCODIGO = :cliente) And\n" +
            "  (condpagto.CPG_ATIVO = 1) And\n" +
            "  (condpagto.cpg_nenvpalm = 0)" , nativeQuery = true)
    fun findCondicaoGeral(cliente: Int) : List<CondPagto>

    @Query(value="Select\n" +
            "  CPG_CODIGO ,\n" +
            "  CPG_DESC \n" +
            "From\n" +
            "  condpagto\n" +
            "Where\n" +
            "  condpagto.CPG_CODIGO = :condicaopagto\n" +
            "union\n" +
            "Select\n" +
            "  CPG_CODIGO,\n" +
            "  CPG_DESC\n" +
            "From\n" +
            "  condpagto\n" +
            "Where\n" +
            "  (condpagto.CPG_CODIGO <> :condicaopagto) And\n" +
            "  (condpagto.CPG_ATIVO = 1) And\n" +
            "  (condpagto.cpg_nenvpalm = 0)" , nativeQuery = true)
    fun findCondicaoGeralCondicao(condicaopagto:Int) : List<CondPagto>

    @Query(value = "Select\n" +
            "  CPG_CODIGO,\n" +
            "  CPG_DESC \n" +
            "From\n" +
            "  condpagto\n" +
            "Where\n" +
            "  condpagto.CPG_CODIGO = :condicaopagto\n" +
            "union\n" +
            "Select\n" +
            "  CPG_CODIGO,\n" +
            "  CPG_DESC\n" +
            "From\n" +
            "  condpagto,\n" +
            "  condpgpessoa\n" +
            "Where\n" +
            "  (condpgpessoa.CPE_CPGCODIGO = condpagto.CPG_CODIGO) And\n" +
            "  (condpagto.CPG_CODIGO <> :condicaopagto) And\n" +
            "  (condpagto.CPG_ATIVO = 1) And\n" +
            "  (condpagto.cpg_nenvpalm = 0) And\n" +
            "  (condpgpessoa.CPE_PESCODIGO = :cliente)" , nativeQuery = true)
    fun findCondicaoCliente(cliente:Int, condicaopagto: Int) :List<CondPagto>
}