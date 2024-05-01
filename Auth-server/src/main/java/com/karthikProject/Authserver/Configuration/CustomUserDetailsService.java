package com.karthikProject.Authserver.Configuration;

import com.karthikProject.Authserver.Entity.UserInfo;
import com.karthikProject.Authserver.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserInfoRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user = repository.findByName(username);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new RuntimeException("No user found"));
    }
}
