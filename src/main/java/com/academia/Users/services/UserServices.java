package com.academia.Users.services;


import com.academia.Exceptions.ModelNotFoundException;
import com.academia.Users.DTOs.CreateUserRequestDTO;
import com.academia.Users.DTOs.UpdateUserRequestDTO;
import com.academia.Users.DTOs.UserResponseDTO;
import com.academia.Users.Validation.UserValidation;
import com.academia.Users.mappers.UserMapper;
import com.academia.Users.models.UserModel;
import com.academia.Users.repositories.UserRepository;
import com.academia.Users.shared.StandardResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private UserValidation userEmailValidation;


    public ResponseEntity<Object> create(@Valid CreateUserRequestDTO data) {
        userEmailValidation.validateEmail(data);

        String encryptedPassword = passwordEncoder.encode(data.password());
        UserModel newUser = new UserModel(data.name(), data.email(), encryptedPassword, data.role());
        userRepository.save(newUser);

        StandardResponseDTO response = new StandardResponseDTO("success", "Usuário criado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public List<UserModel> findAll(String search) {
        if (search == null || search.trim().isEmpty()){
            List<UserModel> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
            if (users.isEmpty()) throw new ModelNotFoundException();
            return users;
        } else {
            List<UserModel> userByName = userRepository.findAllByName(search);
            return userByName;
        }
    }

    public Optional<UserModel> findById(int id) {
        return userRepository.findById(id);
    }

    public ResponseEntity<UserResponseDTO> update(int id, @Valid UpdateUserRequestDTO updateUserRequestDTO) {
        Optional<UserModel> response = userRepository.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        var userModel = response.get();
        BeanUtils.copyProperties(updateUserRequestDTO, userModel, "password");


        if (updateUserRequestDTO.password() != null && !updateUserRequestDTO.password().isBlank()) {
            String encryptedPassword = passwordEncoder.encode(updateUserRequestDTO.password());
            userModel.setPassword(encryptedPassword);
        }

        userRepository.save(userModel);
        UserResponseDTO userResponseDTO = userMapper.toUserResponse(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
    }


    public ResponseEntity<Object> delete(int id){
        Optional<UserModel> response = userRepository.findById(id);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        userRepository.delete(response.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
    }

}
