package com.karthikProject.Authserver.Controller;

import com.karthikProject.Authserver.DTO.NameAndPassword;
import com.karthikProject.Authserver.DTO.UserInfoDTO;
import com.karthikProject.Authserver.Entity.UserInfo;
import com.karthikProject.Authserver.Exception.UserNotFoundException;
import com.karthikProject.Authserver.Service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserInfoController {
    @Autowired
    UserInfoService service;

    @Autowired
    AuthenticationManager manager;

    @PostMapping("/createuser")
    @Operation(description = "Save user information",method = "Post",operationId = "1")
    public void saveuser(@RequestBody UserInfo userInfo){
        service.saveUserInfo(userInfo);
    }

    @GetMapping("/{username}")
    @Operation(description = "get user information by Username",method = "get",operationId = "2")
    public ResponseEntity<UserInfoDTO> getUserInfoByName(@PathVariable String username){
        return ResponseEntity.ok(service.getUserByName(username));
    }

    @DeleteMapping("/deleteall")
    @Operation(description = "Delete informations present in DB",method = "Delete",operationId = "3")
    public void deleteAll(){
        service.deleteAll();
    }

    @PostMapping("/jwt/generate")
    @Operation(description = "Generate JWT Token",method = "Post",operationId = "4")
    public String getToken(@RequestBody NameAndPassword authRequest) {
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateJWTToken(authRequest.getName());
        } else {
            throw new UserNotFoundException("Invalid Access");
        }
    }


    @GetMapping("/jwt/validate")
    @Operation(description = "Validate JWT Token",method = "get",operationId = "5")
    public String validateToken(@RequestParam("token") String token) {
        service.validateJWTToken(token);
        return "Token is valid";
    }
}



