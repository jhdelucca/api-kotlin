package br.com.apiKotlin.space.extensions

import br.com.apiKotlin.space.model.Bairro
import br.com.apiKotlin.space.model.Filial
import br.com.apiKotlin.space.request.RequestModelBairro

fun RequestModelBairro.toPostBairroModel(filial:Filial):Bairro {
    return Bairro(codigo = this.codigo , descricao = this.descricao , filial = filial , ativo = 1)
}


fun RequestModelBairro.toPutBairroModel(bairro:Bairro , filial: Filial) : Bairro {
    return Bairro(codigo = this.codigo ,
        descricao = if(this.descricao.isEmpty()){bairro.descricao}else{this.descricao},
        //filial = if(this.filial == 0){filial}else{Filial(this.filial,"")},
        filial = filial,
        ativo = bairro.ativo)
}