package com.karthikProject.Authserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class NameAndPassword {
    private String name;
    private String password;
}
