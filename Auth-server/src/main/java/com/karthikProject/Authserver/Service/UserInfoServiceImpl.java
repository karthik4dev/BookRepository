package com.karthikProject.Authserver.Service;

import com.karthikProject.Authserver.Entity.Roles;
import com.karthikProject.Authserver.Entity.UserInfo;
import com.karthikProject.Authserver.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserInfo getUserByName(String username) {
        Optional<UserInfo> user= userInfoRepository.findByName(username);
        return user.orElseThrow(() -> new RuntimeException("No user found"));
    }

    @Override
    public List<Roles> getUserAuthoritiesById(int id) {
        UserInfo user = userInfoRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        });
        return user.getRolesList();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        String password= passwordEncoder.encode(userInfo.getPassword());
        System.out.println("Current Password is "+password);
        userInfo.setPassword(password);
        userInfoRepository.save(userInfo);
    }

    @Override
    public void deleteAll() {
        userInfoRepository.deleteAll();
    }
}
