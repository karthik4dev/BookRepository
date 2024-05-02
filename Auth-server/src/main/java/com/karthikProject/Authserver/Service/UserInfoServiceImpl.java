package com.karthikProject.Authserver.Service;

import com.karthikProject.Authserver.DTO.UserInfoDTO;
import com.karthikProject.Authserver.Entity.Roles;
import com.karthikProject.Authserver.Entity.UserInfo;
import com.karthikProject.Authserver.Exception.UserAlreadyExistsException;
import com.karthikProject.Authserver.Exception.UserNotFoundException;
import com.karthikProject.Authserver.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDTO getUserByName(String username) {
        UserInfo user= userInfoRepository.findByName(username).orElseThrow(() -> new RuntimeException("No user found"));
        UserInfoDTO DTO = UserInfoDTO.builder()
                .id(user.getId())
                .username(user.getName())
                .roles(user.getRolesList())
                .enabled(user.getEnabled()>0).build();
        return DTO;
    }

    @Override
    public List<Roles> getUserAuthoritiesById(int id) {
        UserInfo user = userInfoRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("Given ID is not present in DB");
        });
        return user.getRolesList();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        String password= passwordEncoder.encode(userInfo.getPassword());
//        System.out.println("Current Password is "+password);
        userInfo.setPassword(password);
        if(userInfoRepository.findByName(userInfo.getName()).isPresent()){
            throw new UserAlreadyExistsException("User with same username "+userInfo.getName()+" already exists");
        }
        userInfoRepository.save(userInfo);
    }

    @Override
    public void deleteAll() {
        userInfoRepository.deleteAll();
    }
}
