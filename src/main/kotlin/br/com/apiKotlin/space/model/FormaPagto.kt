package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name="formapagto")
class FormaPagto(@Id
                 @Column(name = "fpg_codigo")
                 var formaCodigo: String,
                 @Column(name = "fpg_desc")
                 var formaDesc : String) {}