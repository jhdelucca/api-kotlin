package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.model.Parametros
import br.com.apiKotlin.space.repository.ParametrosRepository
import org.springframework.stereotype.Service

@Service
class ParametrosServices(val parametrosRepository: ParametrosRepository) {

    fun findParametros(filial:Int) : Parametros {
        return parametrosRepository.findParametros(filial);
    }
}