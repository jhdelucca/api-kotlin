package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.model.Pessoa
import br.com.apiKotlin.space.repository.PessoaRepository
import org.springframework.stereotype.Service

@Service
class PessoaServices(val pessoaRepository: PessoaRepository) {

    fun getMapping(fantasia:String?): List<Pessoa> {
        fantasia?.let {
            return pessoaRepository.findByFantasia(fantasia)
        }

        return pessoaRepository.findAll().toList()

    }

    fun getById(codigo:Int) : Pessoa {
        return pessoaRepository.findById(codigo).orElseThrow()
    }

    fun getPessoa() : List<Pessoa> {
        return pessoaRepository.findPessoasQuery()
    }
}