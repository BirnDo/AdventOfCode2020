/**
 * Helper class for passwords
 * @param min Part 1: minimum occurrences, Part 2: position 1
 * @param max Part 1: maximum occurrences, Part 2: position 2
 * @param character The character to count/search
 * @param pw The password string
 */
data class Password(val min: Int, val max: Int, val character: Char, val pw: String)

/**
 * Counts the occurrences of the specified characters
 * @param pw List of passwords to validate
 * @return number of valid passwords
 */
fun countChars(pw: List<Password>): Int{
    var truePasswords = 0
    pw.forEach { it ->
        val pwchar = it.character
        var count = 0
        it.pw.forEach {
            if(it == pwchar){
                count++
            }
        }
        if(count >= it.min && count <= it.max){
            truePasswords++
        }
    }
    return truePasswords
}

/**
 * Checks if the character is either at position pw[min-1] or pw[max-1]
 * @param pw List of passwords to validate
 * @return number of valid passwords
 */
fun validatePasswords(pw: List<Password>): Int{
    var validatedPasswords = 0
    pw.forEach { it ->
        var valid = false
        if(it.pw[it.min-1] == it.character && it.pw[it.max-1] != it.character){
            valid = true
        } else if(it.pw[it.min-1] != it.character && it.pw[it.max-1] == it.character){
            valid = true
        }
        if(valid) validatedPasswords++
    }
    return validatedPasswords
}