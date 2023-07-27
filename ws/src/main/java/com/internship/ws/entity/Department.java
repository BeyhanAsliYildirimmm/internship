package com.internship.ws.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Entity
@Data
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    //Bu şekilde oluşturursan sequence tabloları oluşmaz
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //id ismi yeterli
    //Bu tarz birden fazla kelimeli variable oluştururken
    //databasede naming convention senin de yaptığın gibi "my_column_name" şeklinde
    //ama bunu java'ya maplerken javanın naming convention'ına dikkat etmek zorundayız
    // asagıdaki şekilde maplersen sorun olmaz
    private  String name;
    private  String addressDetail;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp deletedAt;

    @OneToOne(mappedBy="department")
    private User userSet;

    // @OneToMany(mappedBy = "department")
    // Set<DepartmentHerarchy> departmentHerarchySet;

    @OneToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;
    @OneToOne
    @JoinColumn(name="department_type_id", nullable=false)
    private DepartmentType departmentType;
    @ManyToOne
    @JoinColumn(name="town_id", nullable=false)
    private Town town;
}
