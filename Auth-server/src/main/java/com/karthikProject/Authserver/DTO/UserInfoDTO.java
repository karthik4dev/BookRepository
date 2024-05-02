package com.karthikProject.Authserver.DTO;

import com.karthikProject.Authserver.Entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserInfoDTO {
    private int id;
    private String username;
    private Boolean enabled;
    private List<Roles> roles;
}