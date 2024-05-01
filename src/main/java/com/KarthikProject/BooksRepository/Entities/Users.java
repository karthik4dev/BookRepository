package com.KarthikProject.BooksRepository.Entities;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity(name = "userDetails")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name",nullable = false)
      private String userName;

    private String password;

    private boolean active;

    @OneToMany(mappedBy = "user",cascade ={CascadeType.DETACH,CascadeType.MERGE,
                                            CascadeType.PERSIST,CascadeType.REFRESH})
    private List<UserAuthorities> roles;



}
