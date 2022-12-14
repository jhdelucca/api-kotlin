package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "natoper")
data class NatOper(
    @Id
    @Column(name = "nat_codigo")
    var natCodigo : String,
    @Column(name = "nat_desc")
    var natDesc : String)