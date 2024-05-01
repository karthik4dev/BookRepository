package com.karthikProject.Authserver.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;


@Entity(name = "User_details")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username",nullable = false)
    private String name;
    @Column(name = "password",nullable = false)
    private String password;
    private int enabled;
    public List<Roles> rolesList;

    public void add(Roles role){
        if(rolesList == null){
            rolesList=new ArrayList<Roles>();
        }
        rolesList.add(role);
    }
}
