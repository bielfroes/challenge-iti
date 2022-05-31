package com.iti.challenge.password.domain.model.dto

import com.iti.challenge.password.domain.model.CheckPassword
import javax.validation.constraints.NotNull

class CheckPasswordDTO {
    @NotNull(message = "password is null")
    var password: String? = null
}

fun CheckPasswordDTO.toEntity(commandDTO: CheckPasswordDTO): CheckPassword {
    val comand = CheckPassword()
    comand.password = commandDTO.password.toString()
    return comand
}
