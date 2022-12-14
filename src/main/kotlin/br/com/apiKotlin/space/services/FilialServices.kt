package br.com.apiKotlin.space.services


import br.com.apiKotlin.space.model.Filial
import br.com.apiKotlin.space.repository.FilialRepository
import org.springframework.stereotype.Service

@Service
class FilialServices(val filialRepository: FilialRepository) {

    fun getById(codigo:Int) : Filial {
        return filialRepository.findById(codigo).orElseThrow()
    }

    fun getFiliais(): List<Filial> {
        return filialRepository.findAll().toList()
    }

    fun getFiliaisUsuario(usuario:String) : List<Filial> {
        return filialRepository.getFiliais(usuario)
    }
}