import java.io.File

fun part01(input: String): Int {
    val presentsGiven: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
    var x = 0
    var y = 0
    var pointer = 0
    do {
        val coords = Pair(x, y)
        val yeah = presentsGiven.getOrPut(coords) { 0 }
        presentsGiven[coords] = yeah + 1

        if (pointer == input.length) {
            break
        }

        if (input[pointer] == '>') {
            x++
        } else if (input[pointer] == '<') {
            x--
        } else if (input[pointer] == '^') {
            y++
        } else if (input[pointer] == 'v') {
            y--
        }

        pointer++
    } while (pointer <= input.length)
    return presentsGiven.count()
}

fun part02(input: String): Int {
    assert(input.length % 2 == 0) { "TODO: input string is not pair-able" }

    val presentsGiven: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
    var santaX = 0
    var santaY = 0
    var roboX = 0
    var roboY = 0
    var pointer = 0
    do {
        val santaCoords = Pair(santaX, santaY)
        val santaYeah = presentsGiven.getOrPut(santaCoords) { 0 }
        presentsGiven[santaCoords] = santaYeah + 1

        val roboCoords = Pair(roboX, roboY)
        val roboYeah = presentsGiven.getOrPut(roboCoords) { 0 }
        presentsGiven[roboCoords] = roboYeah + 1

        if (pointer == input.length) {
            break
        }

        if (input[pointer+0] == '>') {
            santaX++
        } else if (input[pointer+0] == '<') {
            santaX--
        } else if (input[pointer+0] == '^') {
            santaY++
        } else if (input[pointer+0] == 'v') {
            santaY--
        }

        if (input[pointer+1] == '>') {
            roboX++
        } else if (input[pointer+1] == '<') {
            roboX--
        } else if (input[pointer+1] == '^') {
            roboY++
        } else if (input[pointer+1] == 'v') {
            roboY--
        }

        pointer += 2
    } while (pointer <= input.length)
    return presentsGiven.count()
}

fun main() {
    val inputString = File("input.txt").readText()
    assert(part01(">") == 2) { "expected: 2, got: ${part01(">")}" }
    assert(part01("^>v<") == 4) { "expected: 4, got: ${part01("^>v<")}" }
    assert(part01("^v^v^v^v^v") == 2) { "expected: 2, got: ${part01("^v^v^v^v^v")}" }
    println("Part 01: ${part01(inputString)}")

    assert(part02("^v") == 3) { "expected: 3, got: ${part02(">")}" }
    assert(part02("^>v<") == 3) { "expected: 3, got: ${part02("^>v<")}" }
    assert(part02("^v^v^v^v^v") == 11) { "expected: 11, got: ${part02("^v^v^v^v^v")}" }
    println("Part 02: ${part02(inputString)}")
}