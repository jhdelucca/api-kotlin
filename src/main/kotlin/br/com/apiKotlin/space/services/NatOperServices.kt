package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.enun.Errors
import br.com.apiKotlin.space.exception.NotFoundException
import br.com.apiKotlin.space.model.NatOper
import br.com.apiKotlin.space.repository.NatOperRepository
import org.springframework.stereotype.Service

@Service
class NatOperServices(val natOperRepository: NatOperRepository) {

    fun findByNatOper(filial:Int, natureza:String): List<NatOper> {
        return try {
            if(natureza.isEmpty()) natOperRepository.findNatureza(filial)
            else natOperRepository.findNatureza(natureza,filial)
        }catch (e : Exception){
            throw NotFoundException(Errors.VK006.message,Errors.VK006.code)
        }
    }

}