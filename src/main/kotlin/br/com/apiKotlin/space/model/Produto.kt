package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Produto( @Id
               @Column(name = "pro_codigo", unique = true)
               var codigo:Int? =null,
               @Column(name="pro_desc")
               var proDesc: String = "",
               @Column(name="pro_grpcodigo")
               var codGrupo:Int = 0,
               @Column(name="pro_sgpcodigo")
               var codSubgrupo:Int = 0,
               @Column(name="unp_unidade")
               var unidade:String = "",
               @Column(name="unp_quantidade")
                var qtdeUnidade:Int = 0,
               @Column(name="unp_descemb")
               var descUnidad:String = "",
               @Column(name="unp_fatestoque")
               var fatEstoque:Int = 0,
               @Column(name="unp_fatvenda")
               var fatVenda:Int = 0,
               @Column(name="ppr_precovenda")
               var precoVenda:Double = 0.00,
               @Column(name="cbp_codigo")
               var codBarras:String?=null,
               @Column(name="estdisp")
               var estoqueDisponivel:Double? = null,
               @Column(name="referencia")
               var referencia:String = "",
               @Column(name="pro_grvcodigo")
               var grupoVenda:Int = 0,
               @Column(name="grv_exclusivo")
               var exclusivo:Int?=null) { }
