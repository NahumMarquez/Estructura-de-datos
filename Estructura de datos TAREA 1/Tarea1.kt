
interface IBaseNumber {
    val value: Int
    fun printValue()
}

//CLASE PARA NUMEROS PRIMOS
class PrimeNumber(override val value: Int) : IBaseNumber {
    override fun printValue() {
        println("Prime number: $value")
    }
}

//CLASE NUMEROS IMPARES
class OddNumber(override val value: Int) : IBaseNumber {
    val divisors: List<Int> = calculateDivisors(value)

    override fun printValue() {
        println("Odd number: $value, Divisors: $divisors")
    }

    private fun calculateDivisors(number: Int): List<Int> {
        return (1..number).filter { number % it == 0 }
    }
}

//CLASE PARA NUMEROS PARES
class EvenNumber(override val value: Int) : IBaseNumber {
    val divisors: List<Int> = calculateDivisors(value)

    override fun printValue() {
        println("Even number: $value, Divisors: $divisors")
    }

    private fun calculateDivisors(number: Int): List<Int> {
        return (1..number).filter { number % it == 0 }
    }
}

enum class NumberType {
    PRIME, ODD, EVEN
}

data class EvaluationResult(
    val primes: MutableList<PrimeNumber> = mutableListOf(),
    val odds: MutableList<OddNumber> = mutableListOf(),
    val evens: MutableList<EvenNumber> = mutableListOf()
)

class PrimeNumberProcessor {

    fun processRange(range: IntRange): EvaluationResult {
        val result = EvaluationResult()

        for (number in range) {
            when (val type = validateNumber(number)) {
                NumberType.PRIME -> result.primes.add(PrimeNumber(number))
                NumberType.ODD -> result.odds.add(OddNumber(number))
                NumberType.EVEN -> result.evens.add(EvenNumber(number))
            }
        }

        return result
    }
    

    //METODO PRIVADO QUE VALIDAD
    private fun validateNumber(number: Int): NumberType {
        return when {
            isPrime(number) -> NumberType.PRIME
            number % 2 == 0 -> NumberType.EVEN
            else -> NumberType.ODD
        }
    }

    private fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        for (i in 2..Math.sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) return false
        }
        return true
    }
}



fun main() {
    val processor = PrimeNumberProcessor()
    val result = processor.processRange(1..20)

    println("Prime Numbers:")
    result.primes.forEach { it.printValue() }

    println("\nOdd Numbers:")
    result.odds.forEach { it.printValue() }

    println("\nEven Numbers:")
    result.evens.forEach { it.printValue() }
}

