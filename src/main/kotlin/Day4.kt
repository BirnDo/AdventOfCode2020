/**
 * helper class for day four
 * @param byr Birth year between 1920 and 2002
 * @param iyr Issue year between 2010 and 2020
 * @param eyr Expiration year between 2020 and 2030
 * @param hgt Height between 150cm and 193cm or 59in and 76in
 * @param hcl Hair color as a hexadecimal code
 * @param ecl Eye Color, exactly one of: amb blu brn gry grn hzl oth
 * @param pid Passport ID, nine digit number with leading zeros
 * @param cid Country id (optional)
 */
data class Passport(
    var byr: String?,
    var iyr: String?,
    var eyr: String?,
    var hgt: String?,
    var hcl: String?,
    var ecl: String?,
    var pid: String?,
    var cid: String?
)

/**
 * Checks if all fields were given
 * @param list list with all passwords
 * @return number of valid passports
 */
fun validatePassports(list: List<Passport>): Int {
    var valid = 0;
    list.forEach {
        if (it.byr != null && it.iyr != null && it.eyr != null && it.hgt != null && it.hcl != null && it.ecl != null && it.pid != null) {
            valid++;
        }
    }
    return valid
}

/**
 * Checks if all fields are valid
 * @param list list of passwords
 * @return number of strictly valid passports
 */
fun strictPasswordValidation(list: List<Passport>): Int {
    var numValid = 0;
    list.forEach {
        var valid = true
        //#region byr
        if (it.byr != null) {
            val byr = it.byr!!
            if (byr.length != 4) {
                valid = false
            } else {
                val date = byr.toIntOrNull()
                if (date != null) {
                    if (date < 1920 || date > 2002) {
                        valid = false
                    }
                }
            }
        } else {
            valid = false
        }
        //#endregion

        //#region iyr
        if (it.iyr != null) {
            val iyr = it.iyr!!
            if (iyr.length != 4) {
                valid = false
            } else {
                val date = iyr.toIntOrNull()
                if (date != null) {
                    if (date < 2010 || date > 2020) {
                        valid = false
                    }
                }
            }
        } else {
            valid = false
        }
        //#endregion

        //#region eyr
        if (it.eyr != null) {
            val eyr = it.eyr!!
            if (eyr.length != 4) {
                valid = false
            } else {
                val date = eyr.toIntOrNull()
                if (date != null) {
                    if (date < 2020 || date > 2030) {
                        valid = false
                    }
                } else {
                    valid = false
                }
            }
        } else {
            valid = false
        }
        //#endregion

        //#region hgt
        if (it.hgt != null) {
            val hgt = it.hgt!!
            if (hgt.contains("cm")) {
                val number = hgt.split("cm")[0].toIntOrNull()
                if (number == null) {
                    valid = false
                } else if (number < 150 || number > 193) {
                    valid = false
                }
            } else if (hgt.contains("in")) {
                val number = hgt.split("in")[0].toIntOrNull()
                if (number == null) {
                    valid = false
                } else if (number < 59 || number > 76) {
                    valid = false
                }
            } else {
                valid = false
            }
        } else {
            valid = false
        }
        //#endregion

        //#region hcl
        if (it.hcl != null) {
            if (!it.hcl!!.matches("^#(?:[0-9a-f]{6})\$".toRegex())) {
                valid = false
            }
        } else {
            valid = false
        }
        //#endregion

        //#region ecl
        if (it.ecl != null) {
            if (!(it.ecl == "amb" || it.ecl == "blu" || it.ecl == "brn" || it.ecl == "gry" || it.ecl == "grn" || it.ecl == "hzl" || it.ecl == "oth")) {
                valid = false
            }
        } else {
            valid = false
        }
        //#endregion

        //#region pid
        if (it.pid != null) {
            if (it.pid!!.length == 9) {
                if (it.pid!!.toIntOrNull() == null) {
                    valid = false
                }
            } else {
                valid = false
            }
        } else {
            valid = false
        }

        if (valid) {
            numValid++
        }
        //#endregion
    }
    return numValid
}