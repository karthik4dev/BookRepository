package com.karthikProject.Authserver.DTO;

import com.karthikProject.Authserver.Entity.Roles;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Hidden
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