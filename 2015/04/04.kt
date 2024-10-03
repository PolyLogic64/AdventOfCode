import java.security.MessageDigest

fun part01(input: String): Long {
    var output: Long = 0
    while (true) {
        val md5 = "$input$output".md5()
        if (md5.startsWith("00000")) {
            break
        }
        output++
    }
    return output
}

fun part02(input: String): Long {
    var output: Long = 0
    while (true) {
        val md5 = "$input$output".md5()
        if (md5.startsWith("000000")) {
            break
        }
        output++
    }
    return output
}

// Taken from: https://www.baeldung.com/kotlin/md5-hash
@OptIn(ExperimentalStdlibApi::class)
fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(this.toByteArray())
    return digest.toHexString()
}

fun main() {
    val inputString = "iwrupvqb"
    println("Part 01: ${part01(inputString)}")
    println("Part 02: ${part02(inputString)}")
}