package com.yash.ems.report.dto;

import lombok.*;

import java.io.Serializable;
/**
 * This class s used to store and transfer user skill information for report module.
 * @author prachi.kurhe
 * @since 01--3-2023
 */
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
