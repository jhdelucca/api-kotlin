package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class ColaboradorCargo (
    @Id
    @Column(name = "CLB_CODIGO", unique = true)
    var codigo:Int? =null,
    @Column(name="CLB_RAZAO")
    var razao: String = "",
    @Column(name="CRG_SUPVENDA")
    var supVenda:Int = 0,
    @Column(name="CRG_GERVENDA")
    var genVenda:Int = 0) { }
