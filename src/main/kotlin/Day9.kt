/**
 * find a number where no two numbers in the previous 25 numbers add up to this number
 * @param numbers A list of numbers
 * @return the faulty number
 */
fun findWrongNumber(numbers: List<Long>): Long {
    for (i in 50..numbers.lastIndex) {
        val num = numbers[i]
        var valid = false
        for (j in i - 25..i) {
            for (m in i - 25..i) {
                if (numbers[j] + numbers[m] == num) {
                    valid = true
                }
            }
        }
        if (!valid) {
            return num
        }
    }
    return -1
}

/**
 * find contiguous numbers that add up to the faulty number
 * @param numbers a list of numbers
 * @return the sum of the smallest and biggest number of the contiguous numbers
 */
fun findContiguousNumbers(numbers: List<Long>): Long {
    val num = findWrongNumber(numbers)

    var subNums = listOf<Long>()

    for (i in numbers.indices) {
        var checkNum = 0L
        var j = i
        while (checkNum < num) {
            checkNum += numbers[j]
            j++
        }

        if (checkNum == num) {
            subNums = numbers.subList(i, j)
            break
        }
    }

    val min = subNums.minOrNull()
    val max = subNums.maxOrNull()
    if (min != null && max != null) {
        return min + max
    }
    return -1
}