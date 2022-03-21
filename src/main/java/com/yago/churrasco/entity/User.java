package com.yago.churrasco.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime created;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private LocalDateTime updated;

    @Column
    private String username;

    @Column
    private String role;

    public User(LocalDateTime created, String email, String firstName, String lastName, String password, LocalDateTime updated, String username, String role) {
        this.created = created;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.updated = updated;
        this.username = username;
        this.role = role;
    }
}

