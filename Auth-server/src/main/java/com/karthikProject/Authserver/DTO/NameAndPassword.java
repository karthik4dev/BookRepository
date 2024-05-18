package com.karthikProject.Authserver.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Schema(hidden = true)
@Data
@Getter
@Setter
@AllArgsConstructor
public class NameAndPassword {
    private String name;
    private String password;
}
