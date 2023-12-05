fun main() {
    fun part1(input: List<String>): Int {
        //Split bei ": " -> Spiel, Züge

        //Spiel -> alles ab Leerzeichen als Int

        //Züge: Split bei ";" -> List(Zug)

        //Zug: Split bei "," -> Würfel

        //Würfel: Split bei " " -> Anzahl, Farbe

        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(part1(testInput) == 1)
    val resultPart2 = part2(testInput)
    println("Test Part 2: $resultPart2")
    check(part2(testInput) == 1)

    val input = readInput("Day02")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
