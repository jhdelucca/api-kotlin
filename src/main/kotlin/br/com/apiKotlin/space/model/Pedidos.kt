package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity
@IdClass(PedidoID :: class)
class Pedidos (

        //@EmbeddedId
        //var pedidoID: PedidoID,
        @Id
        @Column(name = "PED_FILCODIGO" , unique = true)
        var filial: Int? = null,
        @Id
        @Column(name = "PED_SPVCODIGO" , unique = true)
        var serie: String? = null,
        @Id
        @Column(name = "PED_NUMERO" , unique = true)
        var numero: Int? = null,
        @Column(name="ped_dtemissao")
        var dtEmissao:String = "",
        @Column(name="Ped_Valor")
        var valor:Double = 0.00,
        @Column(name=" ped_pescodigo")
        var clienteCodigo:Int = 0,
        @Column(name="PES_RAZAO")
        var razao:String = "",
        @Column(name="PES_FANTASIA")
        var fantasia:String = "",
        @Column(name="CLB_RAZAO")
        var clbRazao:String = "",
        @Column(name="ped_obs")
        var obs:String = "",
        @Column(name="Ped_vencodigo")
        var vendedorCodigo:Int = 0)

       { }