package br.com.apiKotlin.space.repository

import br.com.apiKotlin.space.model.Cliente
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface ClienteRepository: CrudRepository<Cliente,Int> {

    @Query("select cliente.CLI_PESCODIGO ,\n" +
            "  pessoa.PES_CNPJCPF ,\n" +
            "  pessoa.PES_RAZAO ,\n" +
            "  pessoa.PES_FANTASIA ,\n" +
            "  cliente.CLI_SITUAC1 ,\n" +
            "  round(cliente.cli_limitecre - (cliente.CLI_VALDEBITO +\n" +
            "  cliente.cli_valdebitopr) + Coalesce(limitead.lad_valor, 0.0), 2) As\n" +
            "  limitecred,\n" +
            "  cliente.cli_bloqpend \n" +
            "From\n" +
            "  cliente\n" +
            "  Left Join\n" +
            "  limitead On (cliente.CLI_PESCODIGO = limitead.lad_pescodigo) And\n" +
            "    (limitead.lad_data = CurDate())\n" +
            "  Inner Join\n" +
            "  pessoa On pessoa.PES_CODIGO = cliente.CLI_PESCODIGO\n" +
            "Where\n" +
            "  pessoa.PES_ATIVO = 1\n" +
            "Order By\n" +
            "  pessoa.PES_FANTASIA" , nativeQuery = true)
    fun getClienteGeral():List<Cliente>

    @Query("Select\n" +
            "  cliente.CLI_PESCODIGO ,\n" +
            "  pessoa.PES_CNPJCPF ,\n" +
            "  pessoa.PES_RAZAO ,\n" +
            "  pessoa.PES_FANTASIA ,\n" +
            "  cliente.CLI_SITUAC1 ,\n" +
            "  cliente.cli_bloqpend ,\n" +
            "  round(cliente.cli_limitecre - (cliente.CLI_VALDEBITO +\n" +
            "  cliente.cli_valdebitopr) + Coalesce((Select Sum(limitead.lad_valor)\n" +
            "  From limitead\n" +
            "  Where (cliente.CLI_PESCODIGO = limitead.lad_pescodigo) And\n" +
            "    (limitead.lad_data = CurDate())), 0.0), 2) As limitecred\n" +
            "From\n" +
            "  usuario,\n" +
            "  cliente\n" +
            "  Inner Join\n" +
            "  pessoa On pessoa.PES_CODIGO = cliente.CLI_PESCODIGO\n" +
            "  Left Join\n" +
            "  carteiravend carteiravendi On cliente.CLI_CCLCODIGOI =\n" +
            "    carteiravendi.ccv_cclcodigo\n" +
            "  Left Join\n" +
            "  carteiravend carteiravende On cliente.CLI_CCLCODIGOE =\n" +
            "    carteiravende.ccv_cclcodigo\n" +
            "Where\n" +
            "  (usuario.USR_LOGIN = :usuario) And\n" +
            "  (carteiravendi.ccv_clbcodigo = usuario.USR_CLBCODIGO Or\n" +
            "    carteiravende.ccv_clbcodigo = usuario.USR_CLBCODIGO) And\n" +
            "  (pessoa.PES_ATIVO = 1)\n" +
            "Group By\n" +
            "  cliente.CLI_PESCODIGO,\n" +
            "  pessoa.PES_CNPJCPF,\n" +
            "  pessoa.PES_RAZAO,\n" +
            "  pessoa.PES_FANTASIA,\n" +
            "  cliente.CLI_SITUAC1,\n" +
            "  cliente.cli_bloqpend\n" +
            "Order By\n" +
            " pessoa.PES_FANTASIA" , nativeQuery = true)
    fun getClienteUsuario(usuario:String):List<Cliente>
}