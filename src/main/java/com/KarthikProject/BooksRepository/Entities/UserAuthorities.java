package com.KarthikProject.BooksRepository.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="roles")
@Getter
@Setter
public class UserAuthorities {

    private String userName;

    private String roles;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private Users user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
