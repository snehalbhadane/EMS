package com.yash.ems.report.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;
/**
 * This class s used to store and transfer user information for report module.
 * @author prachi.kurhe
 * @since 01--3-2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserReportDto implements Serializable{
    private long employeeId;
    private String employeeName;
    private long feedbackId;
    private String suggestion;
    private String fileId;

    private List<SkillResponseDto> skillResponseList;
}
