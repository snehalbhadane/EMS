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
@Table(name = "assessment")
public class Assessment {
    @Id
    @GeneratedValue
    private Long assessmentId;
    private String assessmentName;

    @OneToOne
    @JoinColumn(name = "evaluationFormId", referencedColumnName = "evaluationFormId")
    private EvaluationForm evaluationForm;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "assessment-employee-mapping",
            joinColumns = {@JoinColumn(name = "assessmentId")},
            inverseJoinColumns = {@JoinColumn(name = "employeeId")}
    )
    private List<Employee> candidates;
}
