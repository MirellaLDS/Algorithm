fun main(args: Array<String>) {
    println("Começou:")
    val result = canConstruct("ab", "aab")
    println("Resultado: $result")
}
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    var magazineToExist = mutableMapOf<Char, Int>()

    for (current in magazine) {
        var numTimes = magazineToExist[current]

        if(numTimes == null) {
            magazineToExist[current] = 1
            continue
        }
        magazineToExist[current] = ++numTimes
    }

    for (ransomNoteCurrent in ransomNote) {
        var numTimes = magazineToExist[ransomNoteCurrent]
        if (numTimes == null || numTimes <= 0) {
            return false
        }
        magazineToExist[ransomNoteCurrent] = --numTimes
    }
    return true
}