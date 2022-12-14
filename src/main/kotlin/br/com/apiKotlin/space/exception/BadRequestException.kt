package br.com.apiKotlin.space.exception

class BadRequestException(override val message:String, val errorCode:String):Exception() {
}