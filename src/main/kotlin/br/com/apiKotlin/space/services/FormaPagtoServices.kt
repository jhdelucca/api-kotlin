package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.enun.Errors
import br.com.apiKotlin.space.exception.NotFoundException
import br.com.apiKotlin.space.model.FormaPagto
import br.com.apiKotlin.space.repository.FormaPagtoRepository
import org.springframework.stereotype.Service

@Service
class FormaPagtoServices(val formaPagtoRepository: FormaPagtoRepository) {

    fun findByFormaPagto(codigo: Int , formaPagto:String): List<FormaPagto> {
        try {
            var formaCliente = formaPagtoRepository.findByFormaPagtoCliente(codigo)

            if(formaPagto.isEmpty()) {
                if (formaCliente.isEmpty() || formaCliente == null) {
                    formaCliente = formaPagtoRepository.findFormaGeral(codigo)
                }else{
                    formaCliente = formaPagtoRepository.findFormaCliente(codigo)
                }
            }else{
                if(formaCliente.isEmpty() || formaCliente == null) {
                    formaCliente = formaPagtoRepository.findFormaGeral(formaPagto)
                }else{
                    formaCliente = formaPagtoRepository.findFormaCliente(codigo,formaPagto)
                }
            }
            return formaCliente
        } catch (e : Exception){
            throw NotFoundException(Errors.VK005.message,Errors.VK005.code)
        }
    }

}

