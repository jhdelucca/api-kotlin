package br.com.apiKotlin.space.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Id

@Embeddable
class PedidoUnicoId : Serializable{

    @Id
    @Column(name="ipv_unpunidade")
    var unpunidade:String? = null
    @Id
    @Column(name="ipv_unpquant")
    var unpquant:Int?=null
    @Id
    @Column(name="ipv_procodigo")
    var procodigo:Int?=null
}