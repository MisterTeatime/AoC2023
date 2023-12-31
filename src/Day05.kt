fun main() {

    fun part1(input: List<String>): Int {
        var seeds = listOf<Long>()

        var parsingIndex = 0

        for (line in input) {
            when {
                line.isBlank() -> parsingIndex += 1
                !line[0].isDigit() -> continue
                else -> {
                    when (parsingIndex) {
                        0 -> seeds = line.split(":").getOrNull(1)?.trim()?.split(" ")?.mapNotNull { it.toLongOrNull() } ?: listOf()
                    }
                }
            }
        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(part1(testInput) == 1)
    val resultPart2 = part2(testInput)
    println("Test Part 2: $resultPart2")
    check(part2(testInput) == 1)

    val input = readInput("Day05")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

data class Mapping(val source : Long, val length : Long, val difference : Long)
