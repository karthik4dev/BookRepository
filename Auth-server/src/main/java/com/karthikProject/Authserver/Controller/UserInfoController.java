package com.karthikProject.Authserver.Controller;

import com.karthikProject.Authserver.DTO.NameAndPassword;
import com.karthikProject.Authserver.DTO.UserInfoDTO;
import com.karthikProject.Authserver.Entity.UserInfo;
import com.karthikProject.Authserver.Exception.UserNotFoundException;
import com.karthikProject.Authserver.Service.UserInfoService;
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
    public void saveuser(@RequestBody UserInfo userInfo){
        service.saveUserInfo(userInfo);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserInfoDTO> getUserInfoByName(@PathVariable String username){
        return ResponseEntity.ok(service.getUserByName(username));
    }

    @DeleteMapping("/deleteall")
    public void deleteAll(){
        service.deleteAll();
    }

    @PostMapping("/jwt/generate")
    public String getToken(@RequestBody NameAndPassword authRequest) {
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateJWTToken(authRequest.getName());
        } else {
            throw new UserNotFoundException("Invalid Access");
        }
    }


    @GetMapping("/jwt/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateJWTToken(token);
        return "Token is valid";
    }
}



