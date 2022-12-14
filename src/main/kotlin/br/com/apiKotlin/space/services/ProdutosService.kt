package br.com.apiKotlin.space.services

import br.com.apiKotlin.space.model.Produto
import br.com.apiKotlin.space.model.UnidadePro
import br.com.apiKotlin.space.repository.ProdutosRepository
import br.com.apiKotlin.space.repository.UnidadeProRepository
import br.com.apiKotlin.space.request.RequestUnidadePro
import org.springframework.stereotype.Service

@Service
class ProdutosService(val produtosRepository: ProdutosRepository, val unidadeProRepository: UnidadeProRepository) {

    fun getProdutos(filial:Int):List<Produto> {
        return produtosRepository.findProdutos(filial);
    }

    fun getUnidadePro(requestUnidadePro: RequestUnidadePro):List<UnidadePro> {

        if(requestUnidadePro.unidade.isNotEmpty()  && requestUnidadePro.undquant > 0) {

            return unidadeProRepository.getUnidadeProdutoCodigo(requestUnidadePro.filial,requestUnidadePro.codigoProduto,
            requestUnidadePro.unidade,requestUnidadePro.undquant)
        }
        return unidadeProRepository.getUnidadeProduto(requestUnidadePro.filial,
        requestUnidadePro.codigoProduto)
    }

}