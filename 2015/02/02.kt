import java.io.File

fun part01(input: String): Int {
    // Extract Length, Width and Height
    val (l, w, h) = input
                    .split("x")
                    .map { it.toInt() }
                    .sortedDescending()
    
    return 2*l*w + 2*w*h + 2*h*l + w*h
}

fun part02(input: String): Int {
    val (l, w, h) = input
                    .split("x")
                    .map { it.toInt() }
                    .sortedDescending()
    
    return w+w+h+h + l*w*h
}

fun main() {
    val inputString = File("input.txt").readLines()
    assert(part01("2x3x4") == 58)
    assert(part01("1x1x10") == 43)
    
    assert(part02("2x3x4") == 34)
    assert(part02("1x1x10") == 14)

    var totalPaper = 0
    var totalRibbon = 0
    for (input in inputString) {
        totalPaper += part01(input)
        totalRibbon += part02(input)
    }
    println("Part 01: ${totalPaper}")
    println("Part 02: ${totalRibbon}")
}
