package com.example.amazingpcbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Table(name = "users")
@Accessors(chain = true)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(unique = true, nullable = false, length = 100)
    private String login;

    @Column(nullable = false, length = 50)
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Roles roles;

    @OneToOne
    @JoinColumn(name = "personId")
    private Person person;

}
