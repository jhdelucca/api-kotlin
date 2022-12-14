package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.ColaboradorCargo
import br.com.apiKotlin.space.model.Vendedor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface VendedorRepository: CrudRepository<Vendedor, Int>  {

    @Query("Select\n" +
            "vendedor.ven_clbcodigo\n" +
            "From\n" +
            "  usuario,\n" +
            "  vendedor\n" +
            "Where\n" +
            "  (vendedor.ven_clbcodigo = usuario.USR_CLBCODIGO) And\n" +
            "  (usuario.USR_LOGIN = :usuario)" , nativeQuery = true)
    fun getVendedor(usuario: String) : Vendedor
}