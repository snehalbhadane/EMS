package com.yash.ems.report.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SkillResponseDto implements Serializable {
    private Long skillId;
    private String skillName;
    private String remarks;
    private long ratingReceived;
}
