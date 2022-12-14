package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Filial
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface FilialRepository:CrudRepository<Filial,Int> {

    @Query("Select FIL_CODIGO, fil_razao, fil_fantasia\n" +
            "From  filial , usrfilial\n" +
            "Where filial.FIL_CODIGO = usrfilial.USF_FILCODIGO And\n" +
            "usrfilial.USF_USRLOGIN = :usuario" , nativeQuery = true)
    fun getFiliais(usuario:String) : List<Filial>
}