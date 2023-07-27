package com.internship.ws.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class DepartmentHerarchyKey implements Serializable {
    @Column(name = "child_department_id")
    Integer child_department_id;
    @Column(name = "parent_department_id")
    Integer parent_department_id;
}
