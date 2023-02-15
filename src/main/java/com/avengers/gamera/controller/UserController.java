package com.avengers.gamera.controller;

import com.avengers.gamera.dto.user.UserGetDto;
import com.avengers.gamera.dto.user.UserPostDto;
import com.avengers.gamera.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "Create new user")
    public ResponseEntity<UserGetDto> createUser(@Valid @RequestBody UserPostDto userPostDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userPostDto));
    }
}
