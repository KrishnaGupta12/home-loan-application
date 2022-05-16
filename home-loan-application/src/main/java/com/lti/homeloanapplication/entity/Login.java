package com.lti.homeloanapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="login_table")
public class Login {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGIN_GEN")
    @SequenceGenerator(name = "LOGIN_GEN", sequenceName = "login_id_seq")
    private Long userId;

    @NotNull(message="Username required")
    @Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",message="Invalid Email format")
    private String userName;

    @NotNull(message="Password required")
    private String password;

    @NotNull(message = "Role Required")
    private String role;

}
