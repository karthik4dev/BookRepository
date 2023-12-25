package com.KarthikProject.BooksRepository.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="roles")
@Getter
@Setter
public class UserAuthorities {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId",nullable = false,unique = true)
    private int userId;
    private String userName;

    private String roles;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,
    CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "id")
    private Users user;

}
