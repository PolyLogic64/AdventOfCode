import java.io.File

fun part01(input: String): Int {
    var counter = 0
    input.forEach {
        if (it == '(') {
            counter++
        }
        if (it == ')') {
            counter--
        }
    }
    return counter
}

fun part02(input: String): Int {
    var counter = 0
    input.forEachIndexed { index, it ->
        if (it == '(') {
            counter++
        }
        if (it == ')') {
            counter--
        }
        if (counter < 0) {
            return index + 1
        }
    }
    return 0
}

fun main() {
    val inputString = File("input.txt").readText()
    println("Part 01: ${part01(inputString)}")
    println("Part 02: ${part02(inputString)}")
}
