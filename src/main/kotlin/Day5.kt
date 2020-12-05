import kotlin.math.ceil
import kotlin.math.floor

/**
 * get the IDs of the boarding passes with row * 8 + column
 * @param list boarding passes as string
 * @return list of boarding pass IDs
 */
fun getIds(list: List<String>): List<Int> {
    val ids = ArrayList<Int>()
    list.forEach {
        var maxRow = 127
        var minRow = 0
        var maxCol = 7
        var minCol = 0
        var i = 0

        it.forEach { x ->
            if (x == 'F') {
                if (i == 6) {
                    maxRow = minRow
                } else {
                    maxRow -= ceil((maxRow - minRow) / 2.0).toInt()
                }
                i++
            }
            if (x == 'B') {
                if (i == 6) {
                    minRow = maxRow
                } else {
                    minRow = maxRow - floor((maxRow - minRow) / 2.0).toInt()
                }
                i++
            }
            if (x == 'L') {
                if (i == 9) {
                    maxCol = minCol
                } else {
                    maxCol -= ceil((maxCol - minCol) / 2.0).toInt()
                }
                i++
            }
            if (x == 'R') {
                if (i == 9) {
                    minCol = maxCol
                } else {
                    minCol = maxCol - floor((maxCol - minCol) / 2.0).toInt()
                }
                i++
            }
        }

        ids.add(maxRow * 8 + maxCol)

    }
    return ids
}

/**
 * get the missing id, aka your lost boarding pass ID
 * @param list a list with all Boarding pass IDs
 * @return your lost boarding pass
 */
fun getYourId(list: List<Int>): Int {
    var yourId = 0
    val sortedList = list.sorted()
    for (i in sortedList.indices) {
        if (i != 0 && i != list.size - 1){
            if(sortedList[i-1]+1 != sortedList[i]){
                yourId = sortedList[i-1]+1
            }
        }
    }
    return yourId
}