import java.util.LinkedList
import java.util.Queue
import java.util.Stack

// Clase para representar un tipo de pupusa
data class Pupusa(val tipo: String, val cantidad: Int)

// Clase para representar una orden
data class Orden(val cliente: String, val pupusas: List<Pupusa>)

// Cola de órdenes pendientes
val ordenesPendientes: Queue<Orden> = LinkedList()

// Pila de órdenes despachadas
val ordenesDespachadas: Stack<Orden> = Stack()

fun main() {
    while (true) {
        // Mostrar el menú
        println("Bienvenido a la Pupuseria \"El Comalito\"")
        println("Seleccione una opcion:")
        println("1. Registrar una nueva orden")
        println("2. Ver ordenes pendientes")
        println("3. Despachar orden")
        println("4. Ver ordenes despachadas")
        println("5. Salir")
        print("Opcion: ")
        when (readLine()?.toIntOrNull()) {
            1 -> registrarOrden()
            2 -> verOrdenesPendientes()
            3 -> despacharOrden()
            4 -> verOrdenesDespachadas()
            5 -> {
                println("Saliendo del sistema...")
                break
            }
            else -> println("Opción no válida, intente nuevamente.")
        }
    }
}

// Función para registrar una nueva orden
fun registrarOrden() {
    print("Ingrese el nombre del cliente: ")
    val cliente = readLine() ?: return

    print("¿Cuántos tipos de pupusas desea ordenar? ")
    val cantidadTipos = readLine()?.toIntOrNull() ?: return

    val pupusas = mutableListOf<Pupusa>()
    for (i in 1..cantidadTipos) {
        print("Ingrese el tipo de pupusa #$i: ")
        val tipo = readLine() ?: return

        print("Ingrese la cantidad de pupusas $tipo: ")
        val cantidad = readLine()?.toIntOrNull() ?: return

        pupusas.add(Pupusa(tipo, cantidad))
    }

    val orden = Orden(cliente, pupusas)
    ordenesPendientes.add(orden)

    println("Orden registrada para $cliente: ${pupusas.joinToString(", ") { "${it.cantidad} pupusas de ${it.tipo}" }}")
}

// Función para ver las órdenes pendientes
fun verOrdenesPendientes() {
    if (ordenesPendientes.isEmpty()) {
        println("No hay órdenes pendientes.")
    } else {
        println("Órdenes pendientes:")
        ordenesPendientes.forEachIndexed { index, orden ->
            println("${index + 1}. ${orden.cliente}: ${orden.pupusas.joinToString(", ") { "${it.cantidad} pupusas de ${it.tipo}" }}")
        }
    }
}

// Función para despachar una orden
fun despacharOrden() {
    if (ordenesPendientes.isEmpty()) {
        println("No hay órdenes pendientes para despachar.")
    } else {
        val ordenDespachada = ordenesPendientes.remove()
        ordenesDespachadas.push(ordenDespachada)
        println("Despachando la orden de: ${ordenDespachada.cliente}: ${ordenDespachada.pupusas.joinToString(", ") { "${it.cantidad} pupusas de ${it.tipo}" }}")
    }
}

// Función para ver las órdenes despachadas
fun verOrdenesDespachadas() {
    if (ordenesDespachadas.isEmpty()) {
        println("No hay órdenes despachadas.")
    } else {
        println("Órdenes despachadas:")
        ordenesDespachadas.forEachIndexed { index, orden ->
            println("${index + 1}. ${orden.cliente}: ${orden.pupusas.joinToString(", ") { "${it.cantidad} pupusas de ${it.tipo}" }}")
        }
    }
}