package br.com.apiKotlin.space.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity
@IdClass(PedidoUnicoId :: class)
class PedidoUnico(
                        @Column(name="PED_FILCODIGO", unique = true)
                        var filial:Int?=null,
                        @Column(name="PED_SPVCODIGO",unique = true)
                        var serie:String?=null,
                        @Column(name="PED_NUMERO",unique = true)
                        var numero:Int?=null,
                        @Column(name="ped_codorigem")
                        var origem:String= "",
                        @Column(name="ped_lnpcodigo")
                        var lnpCodigo:Int?=null,
                        @Column(name="ped_llccodigo")
                        var llcCodigo:Int?=null,
                        @Id
                        @Column(name="ipv_procodigo" , unique = true)
                        var procodigo:Int?=null,
                        @Column(name="pro_desc")
                        var prodesc:String?=null,
                        @Id
                        @Column(name="ipv_unpunidade" , unique = true)
                        var unpunidade:String?=null,
                        @Id
                        @Column(name="ipv_unpquant" , unique = true)
                        var unpquant:Int ?=null,
                        @Column(name="ipv_quantidade")
                        var quantidade:Double ?=null,
                        @Column(name="ipv_precovenda")
                        var precovenda:Double ?=null,
                        @Column(name="ped_pescodigo")
                        var cliente:Int ?=null,
                        @Column(name="PES_RAZAO")
                        var razao:String?=null,
                        @Column(name="PES_FANTASIA")
                        var fantasia:String ?=null,
                        @Column(name="ped_vencodigo")
                        var vendedor:Int ?=null,
                        @Column(name="CLB_RAZAO")
                        var colaboradorRazao:String?=null,
                        @Column(name="ped_natcodigo")
                        var natCodigo:String?=null,
                        @Column(name="nat_desc")
                        var natDesc:String?=null,
                        @Column(name="ped_fpgcodigo")
                        var fpgCodigo:String ?=null,
                        @Column(name="FPG_DESC")
                        var fpgDesc:String?=null,
                        @Column(name="ped_cpgcodigo")
                        var cpgCodigo:Int?=null,
                        @Column(name="CPG_DESC")
                        var cpgDesc:String ?=null,
                        @Column(name="ped_obs")
                        var pedObs:String?=null,
                        @Column(name="ped_dtemissao")
                        var dtEmissao:String ?=null,
                        @Column(name="precotabela")
                        var precotab:Double?=null,
                        @Column(name="ped_valor")
                        var valorTotal:Double ?=null){ }