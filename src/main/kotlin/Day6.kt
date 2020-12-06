/**
 * calculated teh different answers given by a group
 * @param list A list of answers paired with the group size
 * @return Sum of different answers from each group
 */
fun getDifferentGroupAnswers(list: List<Pair<String,Int>>): Int {
    var sum = 0
    list.forEach {
        val set = mutableSetOf<Char>()
        it.first.forEach { x ->
            set.add(x)
        }
        sum += set.size
    }
    return sum
}

/**
 * calculates the same answers given by a group
 * @param list A list of answers paired with the group size
 * @return Sum of same answers from each group
 */
fun getSameAnswersPerGroup(list: List<Pair<String, Int>>): Int {
    var sum = 0
    list.forEach {
        val set = mutableSetOf<Char>()
        it.first.forEach { x ->
            set.add(x)
        }

        set.forEach { x ->
            val answers = it.first.count { y -> y == x }
            if(answers == it.second){
                sum+=1
            }
        }
    }
    return sum
}