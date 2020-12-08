/**
 * executes the given boot code and calculates the result of acc
 * @param list A list with all the instructions to execute
 * @return final value of acc after execution
 */
fun executeBootCode(list: List<String>): Int {
    val alreadyExecutedLines = mutableSetOf<Int>()
    var acc = 0
    var i = 0
    while (i < list.lastIndex) {
        if (alreadyExecutedLines.contains(i)) {
            break
        }
        val action = list[i].split(" ")[0]
        val number = list[i].split(" ")[1].toInt()
        alreadyExecutedLines.add(i)
        when (action) {
            "acc" -> {
                acc += number; i++
            }
            "jmp" -> i += number
            "nop" -> i++
        }
    }
    return acc
}

/**
 * fixes the corrupted line of code by changing nop to jmp or jmp to nop
 * @param list A lit where one line is corrupted
 * @return the value of acc after the corrupted line has been fixed
 */
fun fixCorruption(list: List<String>): Int {
    var changedList = list.toMutableList()
    val alreadyChanged = mutableSetOf<Int>()
    while (!isFixed(changedList)) {
        var i = 0
        while (i < list.lastIndex) {
            changedList = list.toMutableList()
            if (alreadyChanged.contains(i)) {
                i++
                continue
            }
            val action = list[i].split(" ")[0]
            val number = list[i].split(" ")[1].toInt()
            when (action) {
                "jmp" -> {
                    changedList[i] = "nop $number"; alreadyChanged.add(i); break;
                }
                "nop" -> {
                    changedList[i] = "jmp $number"; alreadyChanged.add(i); break
                }
            }
            i++
        }
    }
    return executeBootCode(changedList)
}

/**
 * helper class to check if the corruption has been fixed
 * @param list a list of instructions
 * @return true if the code executes without errors
 */
private fun isFixed(list: List<String>): Boolean {
    val alreadyExecutedLines = mutableSetOf<Int>()
    var acc = 0
    var i = 0
    while (i < list.lastIndex) {
        if (alreadyExecutedLines.contains(i)) {
            break
        }
        val action = list[i].split(" ")[0]
        val number = list[i].split(" ")[1].toInt()
        alreadyExecutedLines.add(i)
        when (action) {
            "acc" -> {
                acc += number; i++
            }
            "jmp" -> i += number
            "nop" -> i++
        }
    }

    return i == list.lastIndex
}