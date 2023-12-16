fun main() {
    fun hashFunction(input: String): Int {
        return input.fold(0) { hash, char ->
            val ascii = char.code
            val newHash = (ascii + hash) * 17 % 256
            newHash
        }
    }
    fun part1(input: List<String>): Int {

        val result = input[0].split(",").sumOf { hashFunction(it) }

        return result
    }

    fun part2(input: List<String>): Int {
        val boxes = BoxHandler()

        val instructions = input[0].split(",").map {
            it.split("[=-]".toRegex())
        }

        for ((lens, focalLength) in instructions) {
            val box = hashFunction(lens)

            when (focalLength) {
                "" -> boxes.removeLensFromBox(box, lens)
                else -> boxes.addLensToBox(box, lens, focalLength.toInt())
            }
        }

        return boxes.getFocusingPower()

    }

    println(hashFunction("qp"))

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day15_test")
//    val resultPart1 = part1(testInput)
//    println("Test Part 1: $resultPart1")
//    check(part1(testInput) == 1320)

    val resultPart2 = part2(testInput)
    println("Test Part 2: $resultPart2")
    check(part2(testInput) == 145)

    val input = readInput("Day15")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

class BoxHandler {
    private val boxes: MutableMap<Int, MutableList<Pair<String, Int>>> = mutableMapOf()

    fun addLensToBox(box: Int, lens: String, focalLength: Int) {
        if (!boxes.containsKey(box))
            boxes[box] = mutableListOf()

        val index = boxes[box]?.indexOfFirst { it.first == lens }
        if (index != null && index != -1)
            boxes[box]?.set(index, lens to focalLength)
        else
            boxes[box]?.add(lens to focalLength)
    }

    fun removeLensFromBox(box: Int, lens: String) {
        if (boxes.containsKey(box)) {
            val index = boxes[box]?.indexOfFirst { it.first == lens }
            if (index != null && index != -1)
                boxes[box]?.removeAt(index)

            if (boxes[box]?.size == 0)
                boxes.remove(box)
        }
    }

    fun getFocusingPower(): Int {
        val result = boxes.map { (box, lenses) ->
            lenses.mapIndexed { index, (_, focalLength) ->
                (index + 1) * focalLength
            }.sum() * (box + 1)
        }.sum()
        return result
    }
}