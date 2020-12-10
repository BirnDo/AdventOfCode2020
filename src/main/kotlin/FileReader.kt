import java.io.File

/**
 * reads a file where numbers are separated by line breaks
 * @param fileName The path to the data file
 * @return a list of integers
 */
fun readIntegers(fileName: String): List<Int> {
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
fun readSlope(fileName: String): List<String> {
    val list = ArrayList<String>()
    var lines = 0
    File(fileName).forEachLine { lines++ }
    var lineSize = 0
    File(fileName).forEachLine { lineSize = it.length }
    var repeats = 1
    while (lineSize * repeats < lines * 7) {
        repeats++
    }
    File(fileName).forEachLine {
        var addString = ""
        for (i in 1..repeats) {
            addString += it
        }
        list.add(addString)
    }
    return list
}

/**
 * reads a file and splits the batches into a passport
 * @param fileName The path to the data file
 * @return List of passports
 */
fun readPassports(fileName: String): List<Passport> {
    val strings = ArrayList<String>()
    val appendStrings = ArrayList<String>()
    val passports = ArrayList<Passport>()
    File(fileName).forEachLine { strings.add(it) }
    var i = 0
    var insert = ""
    appendStrings.add("")
    strings.forEach {
        if (it == "") {
            appendStrings.add(i, insert)
            i++
            insert = ""
        } else {
            if (appendStrings.size < i)
                appendStrings.add(i, "")
            insert += "$it "
        }
    }
    appendStrings.add(insert)
    appendStrings.removeAt(i)
    appendStrings.forEach { it ->
        val splitLeerzeichen = it.split(" ").toMutableList()
        splitLeerzeichen.removeAt(splitLeerzeichen.lastIndex)
        val splitColon = ArrayList<Pair<String, String>>()
        splitLeerzeichen.map { x -> Pair(x.split(":")[0], x.split(":")[1]) }.forEach { x -> splitColon.add(x) }
        val pt = Passport(null, null, null, null, null, null, null, null)
        splitColon.forEach {
            when (it.first) {
                "byr" -> pt.byr = it.second
                "iyr" -> pt.iyr = it.second
                "eyr" -> pt.eyr = it.second
                "hgt" -> pt.hgt = it.second
                "hcl" -> pt.hcl = it.second
                "ecl" -> pt.ecl = it.second
                "pid" -> pt.pid = it.second
                "cid" -> pt.cid = it.second
            }
        }
        passports.add(pt)
    }
    return passports
}

/**
 * Reads the Boarding pass directions from a file
 * @param fileName The path to the data file
 * @return A list with all boarding passes
 */
fun readBoardingPasses(fileName: String): List<String> {
    return File(fileName).readLines()
}

/**
 * Reads the answers given from the different groups from a file
 * @param fileName The path to the data file
 * @return A list of answers paired with the size of the group
 */
fun readAnswers(fileName: String): List<Pair<String, Int>> {
    val lines = File(fileName).readLines()
    val appendLines = ArrayList<Pair<String, Int>>()
    var insert = ""
    var i = 0
    lines.forEach {
        if (it == "") {
            appendLines.add(Pair(insert, i))
            insert = ""
            i = 0
        } else {
            insert += it
            i++
        }
    }
    appendLines.add(Pair(insert, i))
    return appendLines
}

/**
 * reads all Baggage rules
 * @param fileName The path to the data file
 * @return A list of Baggage rules
 */
fun readAllBags(fileName: String): List<Bag> {
    val allLines = File(fileName).readLines()
    val bags = ArrayList<Bag>()
    allLines.forEach {
        val split = it.split("bags contain")
        if (split[1].contains("no other bags.")) {
            bags.add(Bag(split[0].trim(), ArrayList()))
        } else {
            val subBags = ArrayList<Pair<Bag, Int>>()
            val split2 = split[1].split(",")
            split2.forEach { x ->
                val split3 = x.split(" ")
                subBags.add(Pair(Bag("${split3[2]} ${split3[3]}".trim(), ArrayList()), split3[1].toInt()))
            }
            bags.add(Bag(split[0].trim(), subBags))
        }
    }
    return bags
}

/**
 * reads all lines of the boot code
 * @param fileName The path to the data file
 * @return A list of instructions
 */
fun readBootCode(fileName: String): List<String> {
    return File(fileName).readLines()
}

/**
 * reads all numbers from the XMAS transmission
 * @param fileName The path to the data file
 * @return A list of numbers
 */
fun readNumbers(fileName: String): List<Long> {
    return File(fileName).readLines().map { it.toLong() }
}

/**
 * reads all adapters
 * @param fileName The path to the data file
 * @return A list of numbers
 */
fun readAdapters(fileName: String): List<Int> {
    return File(fileName).readLines().map { it.toInt() }
}