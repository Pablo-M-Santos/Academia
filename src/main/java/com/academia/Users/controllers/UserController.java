package com.academia.Users.controllers;

import com.academia.Users.DTOs.CreateUserRequestDTO;
import com.academia.Users.DTOs.UpdateUserRequestDTO;
import com.academia.Users.DTOs.UserResponseDTO;
import com.academia.Users.mappers.UserMapper;
import com.academia.Users.repositories.UserRepository;
import com.academia.Users.services.UserServices;
import com.academia.Users.shared.StandardResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServices userServices;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<StandardResponseDTO> create(@RequestBody @Valid CreateUserRequestDTO data) {
        return userServices.create(data);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserResponseDTO>> getAll(@RequestParam(required = false) String search){
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.toUserResponseList(userServices.findAll(search)));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.toUserResponse(userServices.findById(id).get()));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<StandardResponseDTO> update(@PathVariable(value="id") int id, @RequestBody @Valid UpdateUserRequestDTO updateUserRequestDTO){
        return userServices.update(id, updateUserRequestDTO);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<StandardResponseDTO> delete(@PathVariable(value="id") int id){
        return userServices.delete(id);
    }
}
