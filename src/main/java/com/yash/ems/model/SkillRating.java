package com.yash.ems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill-ratings")
public class SkillRating {
    @Id
    @GeneratedValue
    private Long skillRatingId;

    @OneToOne
    @JoinColumn(name = "skillId", referencedColumnName = "skillId")
    private Skill skill;

    private int rating;
    private String remarks;
}
