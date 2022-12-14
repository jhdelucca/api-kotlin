package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Parametros
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ParametrosRepository:CrudRepository<Parametros,Int> {
    @Query("Select\n" +
            "  parametrovap.PAP_FILCODIGO,\n" +
            "  parametrovap.PAP_EXIBEPRECO\n" +
            "From\n" +
            "  parametrovap\n" +
            "Where\n" +
            "  parametrovap.PAP_FILCODIGO = :filial" , nativeQuery = true)
    fun findParametros(filial:Int):Parametros
}