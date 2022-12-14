package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Pessoa
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PessoaRepository:CrudRepository<Pessoa,Int> {

    fun findByFantasia(fantasia:String) :List<Pessoa>

    @Query("Select\n" +
            "  PES_CODIGO,\n" +
            "  PES_FANTASIA \n" +
            "From\n" +
            "  pessoa\n" +
            "  Inner Join\n" +
            "  cliente On pessoa.PES_CODIGO = cliente.CLI_PESCODIGO\n" +
            "Where\n" +
            "  pessoa.PES_ATIVO = 1\n" +
            "Order By\n" +
            "  pessoa.PES_FANTASIA" , nativeQuery = true)
    fun findPessoasQuery() : List<Pessoa>

}