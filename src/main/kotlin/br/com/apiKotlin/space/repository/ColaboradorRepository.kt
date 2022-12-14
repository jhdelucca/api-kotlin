package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.ColaboradorCargo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ColaboradorRepository : CrudRepository<ColaboradorCargo, Int> {

    @Query("Select\n" +
            "  colaborador.CLB_CODIGO,\n" +
            "  colaborador.CLB_RAZAO,\n" +
            "  cargo.crg_supvenda,\n" +
            "  cargo.crg_gervenda\n" +
            "From\n" +
            "  usuario,\n" +
            "  colaborador\n" +
            "  Left Join\n" +
            "  cargo On colaborador.CLB_CRGCODIGO = cargo.CRG_CODIGO\n" +
            "Where\n" +
            "  (colaborador.CLB_CODIGO = usuario.USR_CLBCODIGO) And\n" +
            "  (usuario.USR_LOGIN = :usuario)" , nativeQuery = true)
    fun getColaboradorCargo(usuario:String) : ColaboradorCargo

}