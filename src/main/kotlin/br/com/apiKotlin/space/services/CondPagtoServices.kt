package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.enun.Errors
import br.com.apiKotlin.space.exception.NotFoundException
import br.com.apiKotlin.space.model.CondPagto
import br.com.apiKotlin.space.repository.CondPagtoRepository
import org.springframework.stereotype.Service

@Service
class CondPagtoServices(val condPagtoRepository: CondPagtoRepository) {

    fun findByCondPagto(cliente: Int,condPagto: Int): List<CondPagto> {

        try {
            var condicaoCliente = condPagtoRepository.findByCondPagtoCliente(cliente)
           if(condPagto == 0 || condPagto == null) {
               if (condicaoCliente.isEmpty() || condicaoCliente == null){
                   condicaoCliente = condPagtoRepository.findCondicaoGeral(cliente)
               }else{
                   condicaoCliente = condPagtoRepository.findCondicaoCliente(cliente)
               }
           }else{
               if (condicaoCliente.isEmpty() || condicaoCliente == null){
                   condicaoCliente = condPagtoRepository.findCondicaoGeralCondicao(condPagto)
               }else{
                   condicaoCliente = condPagtoRepository.findCondicaoCliente(cliente,condPagto)
               }
           }
            return condicaoCliente
        } catch (e : Exception){
            throw NotFoundException(Errors.VK003.message, Errors.VK003.code)
        }
    }

}