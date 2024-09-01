//Ejercicio 2: FizzBuzz

//U20240745 GUSTAVO NAHUM MARQUEZ CRUZ

fun fizzBuzz(n: Int) {
    val fizz = { i: Int -> i % 3 == 0 }
    val buzz = { i: Int -> i % 5 == 0 }

    for (i in 1..n) {
        when {
            fizz(i) && buzz(i) -> print("FizzBuzz ")
            fizz(i) -> print("Fizz ")
            buzz(i) -> print("Buzz ")
            else -> print("$i ")
        }
        if (i % 10 == 0) println()
    }
}

fun main() {
    fizzBuzz(100)
} 

