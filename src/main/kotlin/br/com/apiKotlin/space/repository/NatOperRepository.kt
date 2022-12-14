package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.NatOper
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface NatOperRepository : CrudRepository<NatOper,Int> {

    @Query(value = "select nat_codigo, nat_desc from natoper,classificanatop where NAT_SAIDA = 1 and NAT_ENTRADA = 0 AND cnt_tiponatop = 'V' and nat_cntcodigos = cnt_codigo",
        nativeQuery = true)
    fun findByNatOper(): List<NatOper>

    /** Maker **/

    @Query(value = "Select\n" +
            "  Nat_Codigo,\n" +
            "  Nat_Desc,\n" +
            "  1 As ordercod\n" +
            "From\n" +
            "  natoper\n" +
            "Where\n" +
            "  natoper.Nat_Codigo = :natureza\n" +
            "union\n" +
            "Select\n" +
            "  Nat_Codigo,\n" +
            "  Nat_Desc,\n" +
            "  2 As ordercod\n" +
            "From\n" +
            "  natoper,\n" +
            "  natoperfilial,\n" +
            "  parametro\n" +
            "Where\n" +
            "  (natoper.Nat_Codigo = natoperfilial.nof_natcodigo) And\n" +
            "  (natoperfilial.nof_filcodigo = parametro.PAR_FILCODIGO) And\n" +
            "  (natoper.Nat_Codigo <> :natureza) And\n" +
            "  (natoper.Nat_Ativo = 1) And\n" +
            "  (natoper.NAT_SAIDA = 1) And\n" +
            "  (natoperfilial.nof_inativo = 0) And\n" +
            "  (natoperfilial.nof_envpalm = 1) And\n" +
            "  (natoperfilial.nof_filcodigo = :filial)\n" +
            "Order By\n" +
            "  ordercod,\n" +
            "  Nat_Desc" , nativeQuery = true)
    fun findNatureza(natureza:String , filial:Int) :List<NatOper>

    @Query(value = "Select\n" +
            "  Nat_Codigo,\n" +
            "  Nat_Desc,\n" +
            "  1 As ordercod\n" +
            "From\n" +
            "  natoper,\n" +
            "  natoperfilial,\n" +
            "  parametrovap\n" +
            "Where\n" +
            "  (natoper.Nat_Codigo = natoperfilial.nof_natcodigo) And\n" +
            "  (natoper.Nat_Codigo = parametrovap.PAP_NATCODIGO) And\n" +
            "  (natoperfilial.nof_filcodigo = parametrovap.PAP_FILCODIGO) And\n" +
            "  (natoper.Nat_Ativo = 1) And\n" +
            "  (natoper.NAT_SAIDA = 1) And\n" +
            "  (natoperfilial.nof_inativo = 0) And\n" +
            "  (natoperfilial.nof_envpalm = 1) And\n" +
            "  (natoperfilial.nof_filcodigo = :filial)\n" +
            "union\n" +
            "Select\n" +
            "  Nat_Codigo,\n" +
            "  Nat_Desc,\n" +
            "  2 As ordercod\n" +
            "From\n" +
            "  natoper,\n" +
            "  natoperfilial,\n" +
            "  parametrovap\n" +
            "Where\n" +
            "  (natoper.Nat_Codigo = natoperfilial.nof_natcodigo) And\n" +
            "  (natoper.Nat_Codigo <> parametrovap.PAP_NATCODIGO) And\n" +
            "  (natoperfilial.nof_filcodigo = parametrovap.PAP_FILCODIGO) And\n" +
            "  (natoper.Nat_Ativo = 1) And\n" +
            "  (natoper.NAT_SAIDA = 1) And\n" +
            "  (natoperfilial.nof_inativo = 0) And\n" +
            "  (natoperfilial.nof_envpalm = 1) And\n" +
            "  (natoperfilial.nof_filcodigo = :filial)\n" +
            "Order By\n" +
            "  ordercod,\n" +
            "  Nat_Desc", nativeQuery = true)
    fun findNatureza(filial:Int) :List<NatOper>
}