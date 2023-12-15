package com.KarthikProject.BooksRepository.Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;


@Setter
@Entity(name = "Application_property")
public class ApplicationProperty {

    @Value("${owner.name}")
    @Column(name="owner_name",unique = true,nullable = false)
    private String ownerName;

    @Value("${owner.company}")
    @Column(name="company",unique = true,nullable = false)
    private String company;

    @Value(value = "${info.app.name}:Book_Application")
    @Column(name = "Application_Name",nullable = false)
    private String applName;

    @Value("${info.app.version}")
    @Column(name = "Application_version",nullable = false)
    private String applVersion;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public ApplicationProperty() {;
    }


}