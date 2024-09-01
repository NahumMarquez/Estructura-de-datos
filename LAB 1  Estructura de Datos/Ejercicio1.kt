//Ejercicio 1: Conteo de Números Primos, Pares e Impares

//U20240745 GUSTAVO NAHUM MARQUEZ CRUZ

class Numero(val valor: Int) {
    fun esPrimo(): Boolean {
        if (valor < 2) return false
        for (i in 2 until valor) {
            if (valor % i == 0) return false
        }
        return true
    }

    fun esPar() = valor % 2 == 0
    fun esImpar() = valor % 2 != 0
}

fun contarNumeros(n: Int) {
    if (n <= 0) {
        println("N debe ser mayor que cero.")
        return
    }

    var primos = 0
    var pares = 0
    var impares = 0

    for (i in 1..n) {
        val numero = Numero(i)
        if (numero.esPrimo()) primos++
        if (numero.esPar()) pares++
        if (numero.esImpar()) impares++
    }

    println("Cantidad de primos: $primos")
    println("Cantidad de pares: $pares")
    println("Cantidad de impares: $impares")
}

fun main() {
    contarNumeros(30)
}
