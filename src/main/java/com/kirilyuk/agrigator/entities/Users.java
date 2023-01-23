package com.kirilyuk.agrigator.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email; // Это поле нужно убрать!

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;
}
