/**
 * gets the Joltage differences and multiplies them
 * @param list list of adapters
 * @return Multiple of the different joltages
 */
fun getJoltageDifferences(list: List<Int>): Int {
    var sortedList = list.sorted().toMutableList()
    sortedList = sortedList.sorted().toMutableList()
    var threeJolt = 0
    var oneJolt = 0
    for (i in 0 until sortedList.lastIndex) {
        if (sortedList[i] + 3 == sortedList[i + 1]) {
            threeJolt++
        } else if (sortedList[i] + 1 == sortedList[i + 1]) {
            oneJolt++
        }
    }
    return threeJolt * oneJolt
}

fun getDifferentCombinations(list: List<Int>): Long {
    fun valueAtIndex(LongList: Array<Long>, index: Int): Long {
        if (index >= 0) {
            return LongList[index]
        }
        return 0
    }

    var possibilities = Array<Long>(list.size*3) { 0 }
    possibilities[0] = 1

    for (i in 1..list.lastIndex) {
        var currVal = list[i]

        possibilities[currVal] = (valueAtIndex(possibilities, currVal - 1) + valueAtIndex(possibilities, currVal - 2) + valueAtIndex(possibilities, currVal - 3))
    }

    return possibilities.last { it != 0L }
}

//didn't finish part two, maybe finishing another time