package com.internship.ws.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;
@Data
@Entity
@Table(name = "companyType")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    @OneToMany(mappedBy="companyType")
    private Set<Company> companySet;
}
