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
@Table(name = "evaluation-form")
public class EvaluationForm {
    @Id
    @GeneratedValue
    private Long evaluationFormId;
    private String evaluationFormName;
    private int requiredExp;
    private String jobDescription;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "evaluation-form-skill-mapping",
            joinColumns = {@JoinColumn(name = "evaluationFormId")},
            inverseJoinColumns = {@JoinColumn(name = "skillId")}
    )
    private List<Skill> requiredSkills;
}
