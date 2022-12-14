package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "condpagto")
class CondPagto(@Id
                @Column(name = "cpg_codigo")
                var condicaoCodigo : String,
                @Column(name = "cpg_desc")
                var condicaoDesc : String) {}