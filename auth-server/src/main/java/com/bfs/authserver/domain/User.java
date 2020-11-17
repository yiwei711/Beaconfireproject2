package com.bfs.authserver.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user", catalog = "quiz", schema = "quiz")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private String userid;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "status")
    private boolean status;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

}
