package br.com.apiKotlin.space.exception

import java.lang.Exception

class UnauthorizedException(override val message:String, val errorCode:String):Exception() {
}