package com.iti.challenge.password.domain.service

import com.iti.challenge.password.domain.model.*
import com.iti.challenge.password.domain.model.dto.CheckPasswordDTO
import com.iti.challenge.password.domain.model.dto.toEntity
import com.iti.challenge.password.domain.usecase.CheckPasswordUseCase
import org.springframework.stereotype.Service

@Service
class CheckPasswordService: CheckPasswordUseCase {

    override fun handle(commandDTO: CheckPasswordDTO): Boolean {
        val command = commandDTO.toEntity(commandDTO)
        return when {
            !command.isValidateCharactersQuantity() -> return false
            !command.isValidateFieldEmpty() -> return false
            !command.validateCharactersSpecial() -> return false
            !command.isValidateUpperCase() -> return false
            !command.isValidateLowerCase() -> return false
            !command.isValidateCharactersDuplicate() -> return false
            else -> { return true }
        }
    }

}