package com.internship.ws.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Entity
@Data
@Table(name = "departmentType")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private boolean active;
    private String name;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    @OneToOne(mappedBy="departmentType")
    private Department departmentSet;
}
