package com.KarthikProject.BooksRepository.DTOs;

import com.KarthikProject.BooksRepository.Entities.Users;
import com.KarthikProject.BooksRepository.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String userName){
        Users savedUser=userService.getUserByUsername(userName);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping
    public HttpStatus saveUser(@RequestBody Users user){
        userService.saveUser(user);
        return HttpStatus.CREATED;
    }
}
