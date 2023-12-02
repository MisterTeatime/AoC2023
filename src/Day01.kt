fun main() {
    fun convertToDigit(input: String): String {
        val zahlenMap = mapOf(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
        var result = ""
        var index = 0

        while (index < input.length) {
            val currentChar = input[index]

            if (currentChar.isDigit()){
                result += currentChar
                index++
            }
            else
            {
                var found = false

                for ((zahl, zeichen) in zahlenMap) {
                    if (input.startsWith(zahl, index)) {
                        result += zeichen
                        index += zahl.length-1
                        found = true
                        break
                    }
                }

                if (!found)
                    index++
            }
        }

        return result
    }

    fun part1(input: List<String>): Int {
        val summe = input.map { str ->
            str.filter { it.isDigit() }
        }
            .map { zifferString ->
                when {
                    zifferString.length <= 1 -> zifferString.repeat(2)
                    else -> "${zifferString.first()}${zifferString.last()}"
                }
            }.sumOf { zahl -> zahl.toInt() }
        return summe
    }

    fun part2(input: List<String>): Long {
        val summe = input.map { str -> convertToDigit(str) }
            .map { zifferString ->
                when {
                    zifferString.length <= 1 -> zifferString.repeat(2)
                    else -> "${zifferString.first()}${zifferString.last()}"
                }
            }.sumOf { zahl -> zahl.toLong() }
        return summe
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)
    val testInput2 = readInput("Day01_test2")
    //check(part2(testInput2) == 281)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
