package br.com.apiKotlin.space.model
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class PedidoID : Serializable {
    @Column(name = "PED_FILCODIGO")
    var filial: Int? = null

    @Column(name = "PED_SPVCODIGO")
    var serie: String? = null

    @Column(name = "PED_NUMERO")
    var numero: Int? = null
}