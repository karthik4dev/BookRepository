package com.KarthikProject.BooksRepository.Entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "userDetails")
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name",nullable = false)
      private String userName;

    private String password;

    private boolean active;

    @OneToMany(mappedBy = "user")
    private List<UserAuthorities> roles;



}
