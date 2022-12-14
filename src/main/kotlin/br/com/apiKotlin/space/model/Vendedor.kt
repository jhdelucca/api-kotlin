package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Vendedor (
    @Id
    @Column(name="VEN_CLBCODIGO" , unique = true)
    var codigo:Int = 0) { }