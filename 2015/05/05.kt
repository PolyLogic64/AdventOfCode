import java.io.File

fun part01(input: String): Boolean {
    val forbiddenWords = listOf("ab", "cd", "pq", "xy")
    for (forbiddenWord in forbiddenWords) {
        if (input.contains(forbiddenWord)) {
            return false
        }
    }

    var vowelCount = 0
    for (char in input) {
        if (char in "aeiou") {
            vowelCount++
        }
    }

    var doubledLetters = 0
    var prevChar: Char? = null
    for (char in input) {
        if (prevChar == null) {
            prevChar = char
            continue
        }
        
        if (prevChar == char) {
            doubledLetters++
        }
        prevChar = char
    }

    return (vowelCount >= 3) and (doubledLetters >= 1)
}

fun part02(input: String): Boolean {
    TODO("this fucking problem has me stumped")
    assert(input.length % 2 == 0) { "input is not pair-able" }
    val pairCountMap: MutableMap<Pair<Char, Char>, Int> = mutableMapOf()

    for (i in 0..<input.length step 2) {
        val pair = Pair(input[i+0], input[i+1])
        val count = pairCountMap.getOrPut(pair) { 0 }
        pairCountMap[pair] = count + 1
    }
    
    val skippedPairCountMap: MutableMap<Pair<Char, Char>, Int> = mutableMapOf()
    for (i in 0..<input.length-2) {
        val pair = Pair(input[i+0], input[i+2])
        val count = skippedPairCountMap.getOrPut(pair) { 0 }
        skippedPairCountMap[pair] = count + 1
    }
    println(skippedPairCountMap)

    val firstRule = pairCountMap.any { it.value > 1 }
    val secondRule = skippedPairCountMap.any { it.key.first == it.key.second }

    println("$input  firstRule: $firstRule, secondRule: $secondRule")

    return (firstRule and secondRule)
}

fun main() {
    val inputString = File("input.txt").readLines()

    assert(part01("ugknbfddgicrmopn") == true) { "expected: true, got: ${part01("ugknbfddgicrmopn")}" }
    assert(part01("aaa") == true) { "expected: true, got: ${part01("aaa")}" }
    assert(part01("jchzalrnumimnmhp") == false) { "expected: false, got: ${part01("jchzalrnumimnmhp")}" }
    assert(part01("haegwjzuvuyypxyu") == false) { "expected: false, got: ${part01("haegwjzuvuyypxyu")}" }
    assert(part01("dvszwmarrgswjxmb") == false) { "expected: false, got: ${part01("dvszwmarrgswjxmb")}" }

    assert(part02("qjhvhtzxzqqjkmpb") == true) { "expected: true, got: ${part02("qjhvhtzxzqqjkmpb")}" }
    // assert(part02("xxyxx") == true) { "expected: true, got: ${part02("xxyxx")}" }
    assert(part02("uurcxstgmygtbstg") == false) { "expected: false, got: ${part02("uurcxstgmygtbstg")}" }
    assert(part02("ieodomkazucvgmuy") == false) { "expected: false, got: ${part02("ieodomkazucvgmuy")}" }


    var howManyAreNicePart1 = 0
    var howManyAreNicePart2 = 0
    for (word in inputString) {
        howManyAreNicePart1 += if (part01(word)) 1 else 0
        howManyAreNicePart2 += if (part02(word)) 1 else 0
    }
    println("Part 01: ${howManyAreNicePart1}")
    println("Part 02: ${howManyAreNicePart2}")
}