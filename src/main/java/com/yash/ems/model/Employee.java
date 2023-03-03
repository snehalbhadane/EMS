package com.yash.ems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long employeeId;
    private String employeeName;
    private int experienceInMonth;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee-skill-mapping",
            joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "skillId")}
    )
    private List<Skill> skills;
}
