package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.model.Bairro
import br.com.apiKotlin.space.model.Filial
import br.com.apiKotlin.space.model.Imagem
import br.com.apiKotlin.space.repository.BairroRepository
import br.com.apiKotlin.space.repository.ImagemRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.sql.BatchUpdateException

@Service
class BairroServices(val bairroRepository: BairroRepository , val imagemRepository: ImagemRepository) {

    fun getMapping(descricao:String?) : List<Bairro> {
        descricao?.let {
            return bairroRepository.findByDescricaoContaining(descricao)
        }

        return bairroRepository.findAll().toList()
    }

    fun getById(codigo:Int) : Bairro {
        return bairroRepository.findById(codigo).orElseThrow({Exception()})
    }

    fun getByFilial(filial:Filial) : List<Bairro> {
        return bairroRepository.findByFilial(filial).toList()
    }

    fun saveBairro(bairro: Bairro) : Bairro {

        if (bairroRepository.existsById(bairro.codigo.toString().toInt())) {
            throw Exception();
        }

        return bairroRepository.save(bairro)
    }

    fun editBairro(bairro: Bairro) : Bairro {
        if (bairroRepository.existsById(bairro.codigo.toString().toInt())) {
            return bairroRepository.save(bairro)
        }else{
            throw Exception();
        }
    }

    fun deleteBairro(codigo:Int): String {
        if(! bairroRepository.existsById(codigo)) {
            throw Exception()
        }
        bairroRepository.deleteById(codigo)
        return "Deletado"
    }

    fun editImagem(imagem: Imagem) : Imagem {
      return imagemRepository.save(imagem)
    }
}