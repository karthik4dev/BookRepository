package com.karthikProject.Authserver.Controller;

import com.karthikProject.Authserver.DTO.UserInfoDTO;
import com.karthikProject.Authserver.Entity.UserInfo;
import com.karthikProject.Authserver.Service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserInfoController {
    @Autowired
    UserInfoService service;
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

}
