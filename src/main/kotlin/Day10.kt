/**
 * gets the Joltage differences and multiplies them
 * @param list list of adapters
 * @return Multiple of the different joltages
 */
fun getJoltageDifferences(list: List<Int>): Int{
    var sortedList = list.sorted().toMutableList()
    sortedList.add(0)
    sortedList.add(sortedList.maxOrNull()!!+3)
    sortedList = sortedList.sorted().toMutableList()
    var threeJolt = 0
    var oneJolt = 0
    for (i in 0 until sortedList.lastIndex){
        if(sortedList[i]+3 == sortedList[i+1]){
            threeJolt++
        } else if (sortedList[i]+1 == sortedList[i+1]){
            oneJolt++
        }
    }
    return threeJolt* oneJolt
}

//didn't finish part two, maybe finishing another time