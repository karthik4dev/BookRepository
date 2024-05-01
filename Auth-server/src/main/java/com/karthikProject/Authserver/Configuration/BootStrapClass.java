package com.karthikProject.Authserver.Configuration;


import com.karthikProject.Authserver.Entity.UserInfo;
import com.karthikProject.Authserver.Entity.Roles;
import com.karthikProject.Authserver.Repository.UserInfoRepository;
import com.karthikProject.Authserver.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Configuration
public class BootStrapClass implements CommandLineRunner {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    UserInfoService service;

    ArrayList<Roles> roles = new ArrayList<Roles>(EnumSet.allOf(Roles.class));

    @Override
    public void run(String... args) throws Exception {

        UserInfo user = UserInfo.builder().id(1).name("admin").enabled(1)
                .password("ADMIN").rolesList(roles).build();
        List<UserInfo> users=userInfoRepository.findAllByName(user.getName());
        if(!users.isEmpty()){
            for(UserInfo u:users){
                userInfoRepository.delete(u);
            }
        }
        service.saveUserInfo(user);

    }
}
