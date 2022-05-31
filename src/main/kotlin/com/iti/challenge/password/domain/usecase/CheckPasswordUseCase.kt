package com.iti.challenge.password.domain.usecase

import com.iti.challenge.password.domain.model.dto.CheckPasswordDTO
import org.springframework.validation.annotation.Validated

interface CheckPasswordUseCase {

    fun handle(@Validated command: CheckPasswordDTO): Boolean

}