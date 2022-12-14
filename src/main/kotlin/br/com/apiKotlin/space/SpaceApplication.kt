package br.com.apiKotlin.space

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication()
class SpaceApplication

fun main(args: Array<String>) {
	runApplication<SpaceApplication>(*args)
}
