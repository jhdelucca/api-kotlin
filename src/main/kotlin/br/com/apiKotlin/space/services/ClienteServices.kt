package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.model.Cliente
import br.com.apiKotlin.space.repository.ClienteRepository
import br.com.apiKotlin.space.repository.ColaboradorRepository
import org.springframework.stereotype.Service

@Service
class ClienteServices(val clienteRepository: ClienteRepository) {

    fun getCLientes(usuario:String?) : List<Cliente> {

        if(usuario?.isNotEmpty()!!) {
            return clienteRepository.getClienteUsuario(usuario)
        }
        return clienteRepository.getClienteGeral()
    }
}