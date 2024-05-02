package com.karthikProject.Authserver.Service;

import com.karthikProject.Authserver.DTO.UserInfoDTO;
import com.karthikProject.Authserver.Entity.Roles;
import com.karthikProject.Authserver.Entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserInfoService {


    UserInfoDTO getUserByName(String username);
    List<Roles> getUserAuthoritiesById(int id);
    void saveUserInfo(UserInfo userInfo);
    void deleteAll();
    String generateJWTToken(String name);
    void validateJWTToken(String token);

}
