package com.KarthikProject.BooksRepository.Services;

import com.KarthikProject.BooksRepository.Entities.UserAuthorities;
import com.KarthikProject.BooksRepository.Entities.Users;
import com.KarthikProject.BooksRepository.Repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveUser(Users user){
        List<UserAuthorities> userRoles= user.getRoles();
        Users savedUser  =  Users.builder().userName(user.getUserName())
                .password(passwordEncoder.encode(user.getPassword()))
                .active(user.isActive())
                .roles(userRoles).build();
        userRepo.save(savedUser);
    }

    public Users getUserByUsername(String username){
        Optional<Users> savedUser= userRepo.findByuserName(username);
        return savedUser.orElseThrow(() -> new RuntimeException("No UserName present with name "+ username));
    }
}
