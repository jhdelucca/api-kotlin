package br.com.apiKotlin.space.controller

import br.com.apiKotlin.space.extensions.toPostBairroModel
import br.com.apiKotlin.space.extensions.toPutBairroModel
//import br.com.apiKotlin.space.extensions.toPutBairroModel
import br.com.apiKotlin.space.model.Bairro
import br.com.apiKotlin.space.model.Imagem
import br.com.apiKotlin.space.request.RequestImagem
import br.com.apiKotlin.space.request.RequestModelBairro
import br.com.apiKotlin.space.services.BairroServices
import br.com.apiKotlin.space.services.FilialServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("bairro")
class BairroController (val bairroServices: BairroServices , val filialServices: FilialServices) {

    @GetMapping
    fun getAll(@RequestParam descricao:String?) : List<Bairro>{
        return bairroServices.getMapping(descricao)

    }

    @GetMapping("/{codigo}")
    fun getBairro(@PathVariable(name="codigo") codigo:Int) : Bairro {
        return bairroServices.getById(codigo)
    }

    @GetMapping("/filial")
    fun getBairroFilial(@RequestParam codigo: Int) : List<Bairro> {
        val filial = filialServices.getById(codigo)
        return bairroServices.getByFilial(filial)
    }

    @PostMapping
    fun postBairro(@RequestBody bairro: RequestModelBairro) : Bairro {
        val filial = filialServices.getById(bairro.filial)
       return  bairroServices.saveBairro(bairro.toPostBairroModel(filial))
    }

    @PostMapping("/post")
    fun postBairroObj(@RequestBody bairro: Bairro) : Bairro {
        return bairroServices.saveBairro(bairro)

    }

   /** @PutMapping
    fun putBairro(@RequestBody bairro: Bairro) : Bairro {
        return bairroServices.editBairro(atual)
    }**/

    @PutMapping
    fun putBairro(@RequestBody bairro: RequestModelBairro) : Bairro {
        val atual = bairroServices.getById(bairro.codigo.toString().toInt())
        var filial = atual.filial
       if(bairro.filial.toString().toInt() > 0) {
           filial = filialServices.getById(bairro.filial)
       }
        return bairroServices.editBairro(bairro.toPutBairroModel(atual,filial))
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBairro(@PathVariable codigo:Int):String  {
       return bairroServices.deleteBairro(codigo)
    }

    @PostMapping("/imagem")
    fun putImagem(@RequestBody imagem: RequestImagem ) : Imagem {
        val img = Imagem(imagem.codigo,imagem.desc)
        return bairroServices.editImagem(img)
    }
}