package com.internship.ws.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Entity
@Data
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String shortName;
    private  String addressDetail;
    private boolean active;
    private Timestamp createdAt;

    private Timestamp deletedAt;
    @ManyToOne
    @JoinColumn(name="town_id", nullable=false)
    private Town town;
    @ManyToOne
    @JoinColumn(name="company_type_id", nullable=false)
    private CompanyType companyType;


    @OneToOne(mappedBy="company")
    private Department departmentSet;

}
