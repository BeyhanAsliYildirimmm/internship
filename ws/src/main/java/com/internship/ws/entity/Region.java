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
@Table(name = "region")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Timestamp createdAt;

    @OneToMany(mappedBy="region")
    private Set<Town> townSet;
    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    private City city;
}
