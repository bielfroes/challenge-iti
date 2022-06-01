package com.iti.challenge.password.domain.model

import org.apache.commons.lang3.StringUtils
import java.util.regex.Pattern
import java.util.stream.Stream
import javax.validation.constraints.NotNull

class CheckPassword {
    lateinit var password: @NotNull(message = "password is null") String
}

fun CheckPassword.isValidateFieldEmpty(): Boolean = StringUtils.getDigits(password).isBlank()

fun CheckPassword.isValidateCharactersQuantity() = password.trim().length < 9

fun CheckPassword.validateCharactersSpecial (): Boolean = !Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(password).find()

fun CheckPassword.isValidateCharactersDuplicate(): Boolean = run {
    val splitted = password.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for(i in  splitted.indices) {
        for (o in splitted.indices) {
            if (i == o) continue
            if (splitted[i] == splitted[o]) return true
        }
    }
    return false
}

fun CheckPassword.isValidateUpperCase(): Boolean = run {
    val splitted = password.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val findFirst = Stream.of(*splitted).filter { a: String? ->
        StringUtils.isAllUpperCase(
            a
        )
    }.findFirst()
    return !findFirst.isPresent
}

fun CheckPassword.isValidateLowerCase(): Boolean = run {
    val splitted = password.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val findFirst = Stream.of(*splitted).filter { a: String? ->
        StringUtils.isAllLowerCase(
            a
        )
    }.findFirst()
    return !findFirst.isPresent
}

