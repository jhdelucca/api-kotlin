package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Bairro
import br.com.apiKotlin.space.model.Filial
import br.com.apiKotlin.space.model.Imagem
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ImagemRepository: CrudRepository<Imagem , Int> {

    @Query("select * from fr_acptipo where act_codigo = 1 " , nativeQuery = true)
    fun findByCodigo(): ImagemRepository
}