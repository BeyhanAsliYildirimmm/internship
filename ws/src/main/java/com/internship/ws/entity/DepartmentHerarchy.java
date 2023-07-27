package com.internship.ws.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DepartmentHerarchy {
    @EmbeddedId
    DepartmentHerarchyKey id;
    @ManyToOne(optional = false)
    @MapsId("id")
    @JoinColumn(name = "child_department_id")
    Department child_department_id;
    @ManyToOne(optional = false)
    @MapsId("id")
    @JoinColumn(name = "parent_department_id")
    Department parent_department_id;
}
