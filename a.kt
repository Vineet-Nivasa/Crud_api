fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..num / 2) {
        if (num % i == 0) return false
    }
    return true
}

fun main() {
    println("Enter how many prime numbers to print:")
    val n = readln().toInt()
    var count = 0
    var number = 2

    while (count < n) {
        if (isPrime(number)) {
            println(number)
            count++
        }
        number++
    }
}
