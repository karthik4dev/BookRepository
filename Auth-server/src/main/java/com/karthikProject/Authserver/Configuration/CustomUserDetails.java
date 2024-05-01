package com.karthikProject.Authserver.Configuration;

import com.karthikProject.Authserver.Entity.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails{
    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> roles;

    public CustomUserDetails(UserInfo userInfo){
        this.username=userInfo.getName();
        this.password=userInfo.getPassword();
        this.active= userInfo.getEnabled() > 0;

        if (userInfo.getRolesList()!=null){
            List<GrantedAuthority> roles= userInfo.getRolesList().stream().filter(Objects::nonNull)
                    .map(role -> new SimpleGrantedAuthority(role.toString()))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
