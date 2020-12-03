/**
 * Calculates the tree encounters on a slope where every step is one down and three to the right
 * @param slope The slope to check
 * @return number of trees encountered
 */
fun encounteredTreesSlopeThree(slope: List<String>): Int {
    var trees = 0
    var sideStep = 0
    slope.forEach {
        if (it[sideStep] == '#') {
            trees++
        }
        sideStep += 3
    }
    return trees
}

/**
 * Calculates the multiple of the encountered trees of the different slopes to take
 * Uses the slopes [1,1],[1,3], [1,5], [1,7], [2,1]: (down, right)
 * @param slope The slope to check
 * @return The multiple of the encountered trees of every slope
 */
fun encounteredTreesSlopes(slope: List<String>): Long {
    val pairs = listOf(Pair(1,1), Pair(1,3), Pair(1,5), Pair(1,7), Pair(2,1))
    var result: Long = 1

    for (it in pairs){
        var trees = 0
        var sideStep = 0
        for (i in slope.indices step it.first) {
            if (slope[i][sideStep] == '#') {
                trees++
            }
            sideStep += it.second
        }
        result *= trees
    }

    return result
}