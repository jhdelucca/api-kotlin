package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name="pessoa")
class Pessoa(
    @Id
    @Column(name = "PES_CODIGO", unique = true)
    var codigo:Int? =null,
    @Column(name="PES_FANTASIA")
    var fantasia: String = "") { }