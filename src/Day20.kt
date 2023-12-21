fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day20_test")
    val resultPart1 = part1(testInput)
    println("Test Part 1: $resultPart1")
    check(resultPart1 == 11687500)

//    val resultPart2 = part2(testInput)
//    println("Test Part 2: $resultPart2")
//    check(resultPart2 == 1)

    val input = readInput("Day20")
    println("Part 1: ${part1(input)}")
//    println("Part 2: ${part2(input)}")
}

class Pulse (val sender: CommunicationModule, val receiver: CommunicationModule, val status: Status) {

    enum class Status {
        LOW, HIGH, NONE
    }

}
abstract class CommunicationModule(val label: String)
{
    val receivers: MutableList<CommunicationModule> = mutableListOf()

    abstract fun processPulse(pulse: Pulse): Pulse.Status
}

class FlipFlop(label: String) : CommunicationModule(label) {
    var state = false;

    override fun processPulse(pulse: Pulse): Pulse.Status {
        when (pulse.status) {
            Pulse.Status.LOW -> {
                state = !state
                return when (state) {
                    true -> Pulse.Status.HIGH
                    false -> Pulse.Status.LOW
                }
            }
            else -> { return Pulse.Status.NONE }
        }
    }
}

class Conjunction(label: String) : CommunicationModule(label) {
    private val watchedInputs: MutableMap<String,Pulse.Status> = mutableMapOf()

    fun initialize(inputs: List<CommunicationModule>) {
        if (watchedInputs.isEmpty()) {
            for (input in inputs) {
                watchedInputs[input.label] = Pulse.Status.LOW
            }
        }
    }

    private fun updateWatchedModule(pulse: Pulse) {
        watchedInputs[pulse.sender.label] = pulse.status
    }   override fun processPulse(pulse: Pulse): Pulse.Status {
        updateWatchedModule(pulse)

        return when {
            watchedInputs.all { it.value == Pulse.Status.HIGH } -> Pulse.Status.LOW
            else -> Pulse.Status.HIGH
        }
    }
}

class SimpleModule(label: String) : CommunicationModule(label) {
    override fun processPulse(pulse: Pulse): Pulse.Status {
        return pulse.status
    }

}

class ButtonModule(label: String = "button") : CommunicationModule(label) {
    override fun processPulse(pulse: Pulse): Pulse.Status {
        return Pulse.Status.LOW
    }

}