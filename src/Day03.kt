fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(part1(testInput) == 1)
    val resultPart2 = part2(testInput)
    println("Test Part 2: $resultPart2")
    check(part2(testInput) == 1)

    val input = readInput("Day03")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
