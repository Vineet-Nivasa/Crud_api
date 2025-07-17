// examples/FunctionsDemo.kt

fun greet(name: String): String {
    return "Hello, $name!"
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    println(greet("Vineet"))
    println("Sum of 5 and 3 is: ${add(5, 3)}")
}
