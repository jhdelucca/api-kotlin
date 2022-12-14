package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Bairro
import br.com.apiKotlin.space.model.Filial
import br.com.apiKotlin.space.model.Pessoa
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BairroRepository: CrudRepository<Bairro,Int> {

    fun findByDescricaoContaining(descricao:String) :List<Bairro>

    @Query("select * from bairro where BAI_FILCODIGO = :filial" , nativeQuery = true)
    fun findByFilial(filial:Filial): List<Bairro>

}