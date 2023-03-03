package com.yash.ems.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assessment-feedback")
public class AssessmentFeedback {
    @Id
    @GeneratedValue
    private Long assessmentFeedbackId;

    @OneToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "assessmentId", referencedColumnName = "assessmentId")
    private Assessment assessment;

    @OneToMany
    private List<SkillRating> skillRatingList;
}
    