/**
 * helper class for colored bags
 * @param color the color of the bag
 * @param bags a list of bags with a paired quantity
 */
data class Bag(var color: String, var bags: List<Pair<Bag, Int>>)

/**
 * calculates the amount of bags that can in any form take shiny gold bags
 * @param list A lit with baggage rules
 * @return the number of bags that can take shiny gold bags
 */
fun canTakeGoldBag(list: List<Bag>): Int {
    var stringList: MutableList<String> = ArrayList()
    var tempStringList = stringList

    list.forEach {
        it.bags.forEach { x ->
            if (x.first.color == "shiny gold") {
                tempStringList.add(it.color)
            }
        }
    }
    stringList = tempStringList.toMutableList()

    for (i in 0..7) {
        tempStringList = stringList.toMutableList()
        list.forEach {
            it.bags.forEach { x ->
                stringList.forEach { y ->
                    if (x.first.color == y) {
                        tempStringList.add(it.color)
                    }
                }
            }
        }
        stringList = tempStringList.distinct().toMutableList()
    }
    return stringList.size
}

/**
 * calculates the amount of needed subBags for a certainly colored bag
 * @param list list of baggage rules
 * @param bagColor color of the bag
 * @return number of needed subBags
 */
fun getSubBags(list: List<Bag>, bagColor: String): Int {
    var subBagCount = 1
    var subBags: MutableList<Pair<Bag, Int>> = ArrayList()
    list.forEach {
        if (it.color == bagColor)
            subBags = it.bags.toMutableList()
    }

    subBags.forEach {
        subBagCount += it.second * getSubBags(list, it.first.color)
    }

    return subBagCount
}