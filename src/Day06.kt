import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    fun part1(input: List<String>): Int {
        val times = input.map { line ->
            line.split(":")
                .getOrNull(1) ?: ""
        }

        val raceResults = times.map { time ->
            time.trim()
                .split(" ")
                .filter { it.isNotBlank() }
                .map { num -> num.toInt() }
        }.let { list ->
            require(list.size == 2)
            list[0].zip(list[1])
        }.map { race ->
            val diskriminante = race.first * race.first - 4 * race.second
            var lower = ceil((race.first - sqrt(diskriminante.toDouble())) / 2).toInt()
            var upper = floor((race.first + sqrt(diskriminante.toDouble())) / 2).toInt()

            lower = when (lower * (race.first - lower)) {
                race.second -> lower + 1
                else -> lower
            }

            upper = when (upper * (race.first - upper)) {
                race.second -> upper - 1
                else -> upper
            }

            upper - lower + 1
        }

        return raceResults.fold(1) { produkt, zahl -> produkt * zahl }
    }

    fun part2(input: List<String>): Long {
        val times = input.map { line ->
            line.split(":")
                .getOrNull(1) ?: ""
        }

        val race = times.map { time ->
            time.replace(" ", "").toLong()
        }

        val diskriminante = race[0] * race[0] - 4 * race[1]
        var lower = ceil((race[0] - sqrt(diskriminante.toDouble())) / 2).toLong()
        var upper = floor((race[0] + sqrt(diskriminante.toDouble())) / 2).toLong()

        lower = when (lower * (race[0] - lower)) {
            race[1] -> lower + 1
            else -> lower
        }

        upper = when (upper * (race[0] - upper)) {
            race[1] -> upper - 1
            else -> upper
        }

        return upper - lower + 1
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(part1(testInput) == 288)

    val resultPart2 = part2(testInput)
    println("Test Part 2: $resultPart2")
    check(part2(testInput) == 71503L)

    val input = readInput("Day06")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
