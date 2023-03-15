package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob

@Entity(name="fr_acptipo")
class Imagem(@Id
             @Column(name = "ACT_CODIGO", unique = true)
             var codigo:Int? =null,
             @Lob
             @Column(name="ACT_IMAG")
             var desc: ByteArray
) { }