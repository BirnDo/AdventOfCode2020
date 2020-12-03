/**
 * Finds two numbers in the list, where the sum of the numbers is 2020, and then returns the product of these
 * @param list a list of the numbers to compare
 * @return the product of the two numbers
 */
fun sumOfTwoIs2020(list: List<Int>): Int {
    var retval = 0
    for(i in list){
        for(j in list){
            if(i + j == 2020){
                retval = i*j
            }
        }
    }
    return retval
}

/**
 * Finds three numbers in the list, where the sum of the numbers is 2020, and then returns the product of these
 * @param list a list of the numbers to compare
 * @return the product of the three numbers
 */
fun sumOfThreeIs2020(list: List<Int>): Int {
    var retval = 0
    for(i in list){
        for(j in list){
            for(k in list) {
                if (i + j + k == 2020) {
                    retval = i * j * k
                }
            }
        }
    }
    return retval
}