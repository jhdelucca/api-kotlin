package br.com.apiKotlin.space.enun

enum class Errors(val code:String, val message: String) {

    VK001("VK-001", "Bairro %s não encontrado"),
    VK002("VK-002", "Usuário %s não encontrado"),
    VK003("VK-003","Nenhuma condicao encontrada"),
    VK004("VK-004","Usuário não é Gerente, Supervisor ou Vendedor."),
    VK005("VK-005","Nenhuma forma encontrada"),
    VK006("VK-006","Nenhuma natureza encontrada"),
    VK007("VK-007","Nenhum pedido encontrado"),

}