package com.academia.Users.Validation;


import com.academia.Exceptions.CustomValidationException;
import com.academia.Users.DTOs.CreateUserRequestDTO;
import com.academia.Users.DTOs.UpdateUserRequestDTO;
import com.academia.Users.models.UserModel;
import com.academia.Users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class UserValidation {

    private final UserRepository userRepository;

    public void validateName(CreateUserRequestDTO data){
        if (userRepository.findByName(data.name()) != null){
            throw new CustomValidationException("User name already in use");
        }
    }

    public void validateNameUpdate(UpdateUserRequestDTO data, int id){
        UserModel userModel = userRepository.findById(id).get();

        if (!Objects.equals(userModel.getName(), data.name())){
            if (userRepository.findByName(data.name()) != null){
                throw new CustomValidationException("User name already in use");
            }
        }
    }

    public void validateEmail(CreateUserRequestDTO data) {
        if (userRepository.findByEmail(data.email()) != null) {
            throw new CustomValidationException("Email already in use.");
        }
    }

    public void validateUpdateEmail(UpdateUserRequestDTO data, int id) {
        UserModel userModel = userRepository.findById(id).get();

        if (!Objects.equals(userModel.getEmail(), data.email())){
            if (userRepository.findByEmail(data.email()) != null) {
                throw new CustomValidationException("Email already in use.");
            }
        }
    }
}