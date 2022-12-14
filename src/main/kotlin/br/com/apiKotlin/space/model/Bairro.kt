package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name="bairro")
class Bairro (
    @Id
    @Column(name = "BAI_CODIGO", unique = true)
    var codigo:Int? =null,
    @Column(name="BAI_DESC")
    var descricao: String = "",
    @JoinColumn(name="BAI_FILCODIGO")
    @ManyToOne
    var filial:Filial,
    @Column(name="BAI_ATIVO")
    var ativo:Int) { }