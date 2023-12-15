fun main() {
    fun getHint(input: String) : List<Int> {
        var count = 0
        val hint = input.fold(mutableListOf<Int>()) { acc, char ->
            when (char) {
                '1' -> count++
                else -> {
                    if (count > 0) {
                        acc.add(count)
                        count = 0
                    }
                }
            }
            acc
        }
        if (count > 0) {
            hint.add(count)
        }
        return hint
    }

    fun countValidConfigurations(input: String, hint: List<Int>): Int {
        val countUnknown = input.count { it == '?' }
        val possibleConfigs = mutableListOf<String>()

        for (i in 0 until (1 shl countUnknown)) {
            var configuration = input.replace('?','.')
            var index = 0

            for (j in input.indices) {
                if (input[j] == '?') {
                    configuration = configuration.substring(0,j) + ((i shr index) and 1) + configuration.substring(j + 1)
                    index++
                }
            }
            if (getHint(configuration) == hint)
                possibleConfigs.add(configuration)
        }
        return possibleConfigs.size
    }

    fun part1(input: List<String>): Int {
        val result = input.map { element ->
            val (row, hintString) = element.split(" ")
            val hint = hintString.split(",").map { it.toInt() }

            row.replace("#","1").replace(".", "0") to hint
        }
            .map { pair ->
                countValidConfigurations(pair.first, pair.second)
            }
        return result.sum()
    }

    fun part2(input: List<String>): Int {
        val result = input.map { element ->
            val (baseRow, hintString) = element.split(" ")
            val baseHint = hintString.split(",").map { it.toInt() }

            val row = (1..5).joinToString("?") { baseRow }
            val hint = List(5) { baseHint }.flatten()

            row.replace("#","1").replace(".", "0") to hint
        }
            .map { pair ->
                countValidConfigurations(pair.first, pair.second)
            }
        return result.sum()    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day12_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(part1(testInput) == 21)

    val resultPart2 = part2(testInput)
    println("Test Part 2: $resultPart2")
    check(part2(testInput) == 525152)

    val input = readInput("Day12")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
