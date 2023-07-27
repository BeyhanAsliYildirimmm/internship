package com.internship.ws.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private  String userName;
    private String eMail;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message ="{hoaxify.constraints.password.Pattern.message}" )
    @Column(name = "password")
    private String password;
    private boolean enabled;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    @OneToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;
    @OneToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;
}
