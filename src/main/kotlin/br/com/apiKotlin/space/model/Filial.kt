package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name="filial")
class Filial (
    @Id
    @Column(name="FIL_CODIGO", unique = true)
    var codigo : Int?= null,
    @Column(name="FIL_RAZAO")
    var razao:String,
    @Column(name="FIL_FANTASIA")
    var fantasia:String){ }