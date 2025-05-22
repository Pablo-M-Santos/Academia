package com.academia.Users.DTOs;


import com.academia.Users.models.UserRoleEnum;
import lombok.Builder;

@Builder
public record UserResponseDTO(
        int id,
        String name,
        String email,
        UserRoleEnum role
){
}
