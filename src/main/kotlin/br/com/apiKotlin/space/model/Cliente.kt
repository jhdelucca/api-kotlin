package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Cliente(
    @Id
    @Column(name="CLI_PESCODIGO" , unique = true)
    var codigo:Int? = null,
    @Column(name="PES_CNPJCPF")
    var cpfCnjpj:String = "",
    @Column(name="pes_razao")
    var razao:String = "",
    @Column(name="pes_fantasia")
    var fantasia:String = "",
    @Column(name="cli_situac1")
    var situacao:String = "",
    @Column(name="limitecred")
    var limite:Double = 0.00,
    @Column(name="CLI_bloqpend")
    var bloqueado:Int = 0)  { }