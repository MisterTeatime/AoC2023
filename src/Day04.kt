import kotlin.math.pow

fun main() {
    fun getHittingNumbersCount(card: String) : Int {
        val (winningNumbers, drawnNumbers) = card.split("|").map {
            it.trim().split(" ")
                .filter { i -> i.isNotBlank() }
                .map {
                        num -> num.toInt()
                }

        }

        var hittingCards = 0

        for (number in drawnNumbers) {
            if (winningNumbers.contains(number)) hittingCards += 1
        }
        return hittingCards
    }

    fun part1(input: List<String>): Int {

        val cards = input.map { it.split(":").getOrNull(1) ?: ""}
        var score = 0
        val cardBaseScore = 2

        for (card in cards) {
//            val (winningNumbers, drawnNumbers) = card.split("|").map {
//                it.trim().split(" ")
//                    .filter { i -> i.isNotBlank() }
//                    .map {
//                    num -> num.toInt()
//                }
//            }
//
//            var winningCards = -1
//
//            for (number in drawnNumbers) {
//                if (winningNumbers.contains(number)) winningCards += 1
//            }
            val hittingNumbersCount = getHittingNumbersCount(card) - 1

            if (hittingNumbersCount >= 0) score += cardBaseScore.toDouble().pow(hittingNumbersCount).toInt()

        }

        return score
    }

    fun part2(input: List<String>): Int {
        val cards = input.map { it.split(":").getOrNull(1) ?: ""}
        val cardCounts = List(cards.size) { index -> index }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        for ((index, card) in cards.withIndex()) {
            val hittingNumbersCount = getHittingNumbersCount(card)

            if (hittingNumbersCount > 0) {
                val range = index + 1 until index + 1 + hittingNumbersCount
                range.forEach { cardCounts[it] = (cardCounts[it] ?: 0) + (cardCounts[index] ?: 0) }
            }
        }

        return cardCounts.values.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(part1(testInput) == 13)
    val resultPart2 = part2(testInput)
    println("Test Part 2: $resultPart2")
    check(part2(testInput) == 30)

    val input = readInput("Day04")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
