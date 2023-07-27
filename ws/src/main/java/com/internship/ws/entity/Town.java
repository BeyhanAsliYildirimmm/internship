package com.internship.ws.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;
@Entity
@Data
@Table(name = "town")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name="region_id", nullable=false)
    private Region region;

    @OneToMany(mappedBy="town")
    private Set<Department> departmentSet;
    @OneToMany(mappedBy="town")
    private Set<Company> companySet;
}
