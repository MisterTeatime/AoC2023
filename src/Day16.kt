fun main() {
    fun part1(input: List<String>): Int {
        val uncheckedPositions = mutableListOf<BeamStep>()
        uncheckedPositions.add(BeamStep(0,0, Direction.RIGHT))
        val energizedTiles = mutableSetOf<Pair<Int, Int>>()

        val width = input[0].length
        val height = input.size

        while (uncheckedPositions.isNotEmpty()) {
            val currentPosition = uncheckedPositions.removeAt(0)
            energizedTiles.add(currentPosition.x to currentPosition.y)

            when (input[currentPosition.y][currentPosition.x]) {
                '.' -> 0
                '/' -> 1
                '\\' -> 2
                '|' -> 3
                '-' -> 4
            }
        }


        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day16_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(resultPart1 == 46)

//    val resultPart2 = part2(testInput)
//    println("Test Part 2: $resultPart2")
//    check(resultPart2 == 1)

    val input = readInput("Day16")
    println("Part 1: ${part1(input)}")
//    println("Part 2: ${part2(input)}")
}



data class BeamStep (val x: Int, val y: Int, val direction: Direction)

enum class Direction {
    UP, RIGHT, DOWN, LEFT;

    fun next(): Direction {
        val values = enumValues<Direction>()
        val nextOrdinal = (ordinal + 1) % values.size
        return values[nextOrdinal]
    }

    fun previous(): Direction {
        val values = enumValues<Direction>()
        val previousOrdinal = (ordinal - 1 + values.size) % values.size
        return values[previousOrdinal]
    }
}