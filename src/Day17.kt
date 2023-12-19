import java.awt.Point

fun main() {
    fun part1(input: List<String>): Int {
        val area = Area(input.map { row -> row.map { it.toString().toInt()}.toMutableList()})





        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day17_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(resultPart1 == 102)

//    val resultPart2 = part2(testInput)
//    println("Test Part 2: $resultPart2")
//    check(resultPart2 == 1)

    val input = readInput("Day17")
    println("Part 1: ${part1(input)}")
//    println("Part 2: ${part2(input)}")
}

class TrolleyPathFinder (val area: Area<Int>, private val start: Point2D, private val goal: Point2D){
    private val openList = mutableListOf(start)
    private val closedList = mutableListOf<Point2D>()

}

class TrolleyCost {
    private val costs = mutableMapOf<Point2D, Pair<Point2D, Int>>()

    fun setCost(cell: Point2D, parent: Point2D, cost: Int) {
        costs[cell] = parent to cost
    }

    fun getCost(cell: Point2D) = costs[cell]?.second ?: 0

    fun getParent(cell: Point2D) = costs[cell]?.first
}