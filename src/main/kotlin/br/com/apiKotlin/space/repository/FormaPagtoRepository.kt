package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.FormaPagto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface FormaPagtoRepository:CrudRepository<FormaPagto,Int> {

    @Query( value = "select fpg_codigo, fpg_desc from formapgpessoa,formapagto where\n" +
            "fpg_codigo = fpe_fpgcodigo and fpg_ativo = 1 and fpe_pescodigo= :codigo", nativeQuery = true)
    fun findByFormaPagtoCliente(codigo: Int): List<FormaPagto>

    @Query( value = "select fpg_codigo, fpg_desc from formapagto where fpg_ativo = 1 and fpg_envpalm = 1", nativeQuery = true)
    fun findByFormaPagto(): List<FormaPagto>

    /** MAKER **/

    @Query(value = "Select\n" +
            "  FPG_CODIGO,\n" +
            "  FPG_DESC \n" +
            "From\n" +
            "  formapagto,\n" +
            "  cliente\n" +
            "Where\n" +
            "  (cliente.CLI_FPGCODIGO = formapagto.FPG_CODIGO) And\n" +
            "  (cliente.CLI_PESCODIGO = :cliente) And\n" +
            "  (formapagto.FPG_ATIVO = 1) And\n" +
            "  (formapagto.FPG_ENVPALM = 1)\n" +
            "union\n" +
            "Select\n" +
            "  FPG_CODIGO ,\n" +
            "  FPG_DESC \n" +
            "From\n" +
            "  formapagto,\n" +
            "  cliente\n" +
            "Where\n" +
            "  (formapagto.FPG_CODIGO <> cliente.CLI_FPGCODIGO) And\n" +
            "  (cliente.CLI_PESCODIGO = :cliente) And\n" +
            "  (formapagto.FPG_ATIVO = 1) And\n" +
            "  (formapagto.FPG_ENVPALM = 1)" , nativeQuery = true)
        fun findFormaGeral(cliente:Int):List<FormaPagto>

        @Query(value = "Select\n" +
                "  FPG_CODIGO,\n" +
                "  FPG_DESC \n" +
                "From\n" +
                "  formapagto,\n" +
                "  cliente\n" +
                "Where\n" +
                "  (cliente.CLI_FPGCODIGO = formapagto.FPG_CODIGO) And\n" +
                "  (cliente.CLI_PESCODIGO = :cliente) And\n" +
                "  (formapagto.FPG_ATIVO = 1) And\n" +
                "  (formapagto.FPG_ENVPALM = 1)\n" +
                "union\n" +
                "Select\n" +
                "  FPG_CODIGO,\n" +
                "  FPG_DESC\n" +
                "From\n" +
                "  formapagto,\n" +
                "  formapgpessoa,\n" +
                "  cliente\n" +
                "Where\n" +
                "  (formapgpessoa.FPE_FPGCODIGO = formapagto.FPG_CODIGO) And\n" +
                "  (formapgpessoa.FPE_PESCODIGO = cliente.CLI_PESCODIGO) And\n" +
                "  (formapgpessoa.FPE_FPGCODIGO <> cliente.CLI_FPGCODIGO) And\n" +
                "  (formapgpessoa.FPE_PESCODIGO = :cliente) And\n" +
                "  (formapagto.FPG_ATIVO = 1) And\n" +
                "  (formapagto.FPG_ENVPALM = 1)" , nativeQuery = true)
        fun findFormaCliente(cliente:Int):List<FormaPagto>

        @Query(value = "Select\n" +
                "  FPG_CODIGO ,\n" +
                "  FPG_DESC \n" +
                "From\n" +
                "  formapagto\n" +
                "Where\n" +
                "  formapagto.FPG_CODIGO = :formapagto\n" +
                "union\n" +
                "Select\n" +
                "  FPG_CODIGO ,\n" +
                "  FPG_DESC \n" +
                "From\n" +
                "  formapagto\n" +
                "Where\n" +
                "  (formapagto.FPG_CODIGO <> :formapagto) And\n" +
                "  (formapagto.FPG_ATIVO = 1) And\n" +
                "  (formapagto.FPG_ENVPALM = 1)", nativeQuery = true)
        fun findFormaGeral(formapagto:String):List<FormaPagto>

        @Query(value = "Select\n" +
                "  FPG_CODIGO ,\n" +
                "  FPG_DESC \n" +
                "From\n" +
                "  formapagto\n" +
                "Where\n" +
                "  formapagto.FPG_CODIGO = :formapagto\n" +
                "union\n" +
                "Select\n" +
                "  FPG_CODIGO ,\n" +
                "  FPG_DESC \n" +
                "From\n" +
                "  formapagto,\n" +
                "  formapgpessoa\n" +
                "Where\n" +
                "  (formapgpessoa.FPE_FPGCODIGO = formapagto.FPG_CODIGO) And\n" +
                "  (formapgpessoa.FPE_PESCODIGO = :cliente) And\n" +
                "  (formapgpessoa.FPE_FPGCODIGO <> :formapagto) And\n" +
                "  (formapagto.FPG_ATIVO = 1) And\n" +
                "  (formapagto.FPG_ENVPALM = 1)" , nativeQuery = true)
        fun findFormaCliente(cliente:Int, formapagto:String) :List<FormaPagto>


}