package br.com.apiKotlin.space.response

data class ErroResponse (var httpCode : Int,
                         var message:String,
                         var internalCode: String,
                         var errors: List<FieldErroResponse>? ) { }