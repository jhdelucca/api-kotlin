package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Parametros(
    @Id
    @Column(name="PAP_FILCODIGO")
    val filial: Int?=null,
    @Column(name="PAP_EXIBEPRECO")
    val exibePreco : Int = 0) {
}