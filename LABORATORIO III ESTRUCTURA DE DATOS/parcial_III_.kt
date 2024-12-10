import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println(
            """
            Seleccione una opcion:
            1. Ordenar una lista usando Bubble Sort
            2. Ordenar una lista usando Quick Sort
            3. Calcular el factorial de un numero
            4. Resolver las Torres de Hanoi
            5. Salir
            """.trimIndent()
        )
        print("Opcion: ")
        when (readLine()?.toIntOrNull()) {
            1 -> ordenarBubbleSort()
            2 -> ordenarQuickSort()
            3 -> calcularFactorial()
            4 -> resolverTorresDeHanoi()
            5 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Por favor, ingrese una opción valida.")
        }
    }
}

// Opción 1: Bubble Sort
fun ordenarBubbleSort() {
    val lista = obtenerListaNumeros()
    if (lista.isEmpty()) {
        println("Entrada invalida. Intente nuevamente.")
        return
    }

    val tiempo = measureTimeMillis {
        val ordenado = bubbleSort(lista)
        println("Lista ordenada usando Bubble Sort: $ordenado")
    }
    println("Tiempo de ejecucion: ${"%.3f".format(tiempo / 1000.0)} segundos")
}

fun bubbleSort(lista: List<Int>): List<Int> {
    val arreglo = lista.toMutableList() // Convertimos la lista inmutable en una lista mutable
    for (i in arreglo.indices) {
        for (j in 0 until arreglo.size - i - 1) {
            if (arreglo[j] > arreglo[j + 1]) {
                val temp = arreglo[j]
                arreglo[j] = arreglo[j + 1]
                arreglo[j + 1] = temp
            }
        }
    }
    return arreglo // Devolvemos la lista ordenada
}

// Opción 2: Quick Sort
fun ordenarQuickSort() {
    val lista = obtenerListaNumeros()
    if (lista.isEmpty()) {
        println("Entrada invalida. Intente nuevamente.")
        return
    }

    val tiempo = measureTimeMillis {
        val ordenado = quickSort(lista)
        println("Lista ordenada usando Quick Sort: $ordenado")
    }
    println("Tiempo de ejecucion: ${"%.3f".format(tiempo / 1000.0)} segundos")
}

fun quickSort(arr: List<Int>): List<Int> {
    if (arr.size < 2) return arr
    val pivot = arr[arr.size / 2]
    val equal = arr.filter { it == pivot }
    val less = arr.filter { it < pivot }
    val greater = arr.filter { it > pivot }
    return quickSort(less) + equal + quickSort(greater)
}

// Opción 3: Factorial
fun calcularFactorial() {
    print("Ingrese un numero entero positivo: ")
    val numero = readLine()?.toIntOrNull()

    if (numero == null || numero < 0) {
        println("Por favor, ingrese un numero entero positivo.")
        return
    }

    val factorial = (1..numero).fold(1L) { acc, i -> acc * i }
    println("El factorial de $numero es: $factorial")
}

// Opción 4: Torres de Hanói
var contadorPasos = 0 // Contador global para rastrear los pasos

fun resolverTorresDeHanoi() {
    print("Ingrese el número de discos: ")
    val discos = readLine()?.toIntOrNull()
    if (discos == null || discos <= 0) {
        println("Por favor, ingrese un numero entero positivo mayor a 0.")
        return
    }

    println("Resolviendo Torres de Hanoi con $discos discos:")
    contadorPasos = 0 // Reiniciar el contador antes de resolver
    torresDeHanoi(discos, "A", "C", "B")
}

fun torresDeHanoi(n: Int, origen: String, destino: String, auxiliar: String) {
    if (n == 1) {
        contadorPasos++
        println("Paso $contadorPasos: Mover disco 1 de Torre $origen a Torre $destino")
        return
    }
    torresDeHanoi(n - 1, origen, auxiliar, destino)
    contadorPasos++
    println("Paso $contadorPasos: Mover disco $n de Torre $origen a Torre $destino")
    torresDeHanoi(n - 1, auxiliar, destino, origen)
}

// Función reutilizable para obtener una lista de números
fun obtenerListaNumeros(): List<Int> {
    print("Ingrese una lista de numeros separados por comas: ")
    val input = readLine() ?: ""
    return input.split(",").mapNotNull { it.trim().toIntOrNull() }
}
