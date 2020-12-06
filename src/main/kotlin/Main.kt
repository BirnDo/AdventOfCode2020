import dayFour as dayFour

/**
 * Main method to test the problems of https://adventofcode.com/2020
 */
fun main() {
    //dayOne()
    //dayTwo()
    //dayThree()
    //dayFour()
    //dayFive()
    //daySix()
}

/**
 * Solves the problem of day one
 */
fun dayOne() {
    println("- Day 1 -------------------------------------")
    val numbers = readIntegers("src/main/resources/Day1.txt")
    println("Result for two numbers: ${sumOfTwoIs2020(numbers)}")
    println("Result for three numbers: ${sumOfThreeIs2020(numbers)}")

}

/**
 * Solves the Problem of day two
 */
fun dayTwo() {
    println()
    println("- Day 2 -------------------------------------")
    val passwords = readPasswords("src/main/resources/Day2.txt")
    println("true passwords part 1: ${countChars(passwords)}")
    println("true passwords part 2: ${validatePasswords(passwords)}")
}

/**
 * Solves the problem of day three
 */
fun dayThree() {
    println()
    println("- Day 3 -------------------------------------")
    val geography = readSlope("src/main/resources/Day3.txt")
    println("Encountered Trees Part 1: ${encounteredTreesSlopeThree(geography)}")
    println("Encountered Trees multiplied: ${encounteredTreesSlopes(geography)}")
}

/**
 * Solves Problem of day four
 */
fun dayFour() {
    println()
    println("- Day 4 -------------------------------------")
    val passports = readPassports("src/main/resources/Day4.txt")
    println("valid passports: ${validatePassports(passports)}")
    println("strict valid passports: ${strictPasswordValidation(passports)}")
}

/**
 * Solves the problem of day five
 */
fun dayFive(){
    println()
    println("- Day 5 -------------------------------------")
    val passes = readBoardingPasses("src/main/resources/Day5.txt")
    println("Highest Boarding pass ID : ${getIds(passes).maxByOrNull { it }}")
    println("Your Boarding pass ID: ${getYourId(getIds(passes))}")
}

/**
 * Solves the problem of day six
 */
fun daySix(){
    println()
    println("- Day 6 -------------------------------------")
    val answers = readAnswers("src/main/resources/Day6.txt")
    println("Different Answers per group: ${getDifferentGroupAnswers(answers)}")
    println("Same Answers per group: ${getSameAnswersPerGroup(answers)}")
}