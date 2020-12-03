import java.io.File

/**
 * reads a file where numbers are separated by line breaks
 * @param fileName The path to the data file
 * @return a list of integers
 */
fun readIntegers(fileName: String): List<Int>{
    val numbers = ArrayList<Int>()
    File(fileName).forEachLine { numbers.add(it.toInt()) }
    return numbers
}

/**
 * reads a file where passwords are separated by line breaks in the form "Int-Int Char: String"
 * @param fileName The path to the data file
 * @return a list of the class Password from Day2.kt
 */
fun readPasswords(fileName: String): List<Password> {
    val passwords = ArrayList<Password>()
    File(fileName).forEachLine {
        val rest = it.split(' ')
        val numbers = rest[0].split('-')
        val char = rest[1][0]
        val pw = rest[2]
        passwords.add(Password(numbers[0].toInt(), numbers[1].toInt(), char, pw))
    }
    return passwords
}

/**
 * reads a file where the slope of a hill with trees is saved and repeats it seven times
 * @param fileName The path to the data file
 * @return a list of the geography of the slope
 */
fun readSlope(fileName: String): List<String>{
    val list = ArrayList<String>()
    var lines = 0
    File(fileName).forEachLine { lines++ }
    var lineSize = 0
    File(fileName).forEachLine { lineSize = it.length }
    var repeats = 1
    while (lineSize*repeats < lines*7){
        repeats++
    }
    File(fileName).forEachLine {
        var addString = ""
        for(i in 1..repeats){
            addString += it
        }
        list.add(addString)
    }
    return list
}