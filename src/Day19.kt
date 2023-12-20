fun main() {
    fun part1(input: List<String>): Int {

        val rules = input.takeWhile { it.isNotEmpty() }
            .map { RuleSet(it)}
        val items = input.takeLastWhile { it.isNotEmpty() }

        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day19_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(resultPart1 == 19114)

//    val resultPart2 = part2(testInput)
//    println("Test Part 2: $resultPart2")
//    check(resultPart2 == 1)

    val input = readInput("Day19")
    println("Part 1: ${part1(input)}")
//    println("Part 2: ${part2(input)}")
}

data class Item(val x: Int, val m: Int, val a: Int, val s: Int)

data class Rule(val category: String, val comparator: String, val value: Int, val nextRule: String)

class RuleSet(input: String) {
    val label: String = input.takeWhile { it != '{'}
    val rules: List<Rule> = input.takeLastWhile { it != '{'}.dropLast(1).split(",")
        .map { rule ->
            val regex = Regex("""(\w)?([><])?(\d+)?:?(\w+|(\w))""")
            val matchResult = regex.find(rule)

                val (category, comparator, value, target) = matchResult!!.destructured

                when {
                    comparator == null -> Rule("","",0, target)
                    else -> Rule(category, comparator, value.toInt(), target)
                }
        }
}