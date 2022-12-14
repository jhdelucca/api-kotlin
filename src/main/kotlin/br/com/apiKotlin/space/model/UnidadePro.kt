package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class UnidadePro(@Id
                 @Column(name = "pro_codigo", unique = true)
                 var codigo:Int? =null,
                 @Column(name="pro_desc")
                 var proDesc: String = "",
                 @Column(name="unp_unidade")
                 var unidade:String = "",
                 @Column(name="unp_quantidade")
                 var qtdeUnidade:Int = 0,
                 @Column(name="precounp")
                 var precoVenda:Double = 0.00,
                 @Column(name="unp_fatestoque")
                 var fatEstoque:Int = 0,
                 @Column(name="unp_fatvenda")
                 var fatVenda:Int = 0,
                 @Column(name="estdisp")
                 var estoqueDisponivel:Double? = null){}