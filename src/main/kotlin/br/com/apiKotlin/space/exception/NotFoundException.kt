package br.com.apiKotlin.space.exception

class NotFoundException(override val message:String, val errorCode:String):Exception() {
}