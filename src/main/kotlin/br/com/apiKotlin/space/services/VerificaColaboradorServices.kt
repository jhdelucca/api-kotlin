package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.model.ColaboradorCargo
import br.com.apiKotlin.space.model.Vendedor
import br.com.apiKotlin.space.repository.ColaboradorRepository
import br.com.apiKotlin.space.repository.VendedorRepository
import org.springframework.stereotype.Service

@Service
class VerificaColaboradorServices(val colaboradorRepository: ColaboradorRepository, val vendedorRepository: VendedorRepository) {

    fun getColaboradorCargo(usuario:String) : ColaboradorCargo {
        return  colaboradorRepository.getColaboradorCargo(usuario)
    }

    fun getVendedor(usuario: String) : Vendedor {

     //   try {
            val vendedor = vendedorRepository.getVendedor(usuario)
            return vendedor
      //  }catch (ex:Exception ) {
        //   return Vendedor(0)
       // }


       // return vendedorRepository.getVendedor(usuario);
    }
}