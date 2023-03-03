package com.yash.ems.report.service.impl;

import com.yash.ems.report.dto.SkillResponseDto;
import com.yash.ems.report.dto.UserReportDto;
import com.yash.ems.report.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to implement api specifications defined by {@link ReportService}.
 * @author prachi.kurhe
 * @since 01--3-2023
 */
@Service
public class ReportServiceImpl implements ReportService {
    //TODO need to remove as this is the mock data .
    private static Map<Long, UserReportDto> userReportMap = new HashMap<>();
    private static final List<String> userNames = List.of(
            "Sachin",
            "Prachi",
            "Aniket",
            "Swati",
            "Aishwarya",
            "karishma"
    );

    static {
        int min = 0;
        int max = 10;
        long userId = 100;
        for (String username : userNames) {
            List<SkillResponseDto> skillResponseList = List.of(
                    SkillResponseDto.builder().skillName("Communication Skill")
                            .ratingReceived((int) (Math.random() * (max - min + 1) + min))
                            .build(),
                    SkillResponseDto.builder().skillName("Coding skill")
                            .ratingReceived((int) (Math.random() * (max - min + 1) + min))
                            .build(),
                    SkillResponseDto.builder().skillName("Presentation skill")
                            .ratingReceived((int) (Math.random() * (max - min + 1) + min))
                            .build(),
                    SkillResponseDto.builder().skillName("Leadership skills")
                            .ratingReceived((int) (Math.random() * (max - min + 1) + min))
                            .build(),
                    SkillResponseDto.builder().skillName("Company value")
                            .ratingReceived((int) (Math.random() * (max - min + 1) + min))
                            .build()
            );

            UserReportDto userReportDto = UserReportDto.builder()
                    .employeeId(userId)
                    .employeeName(username)
                    .feedbackId(234)
                    .skillResponseList(skillResponseList)
                    .build();
            System.out.println(userId+" ===== "+userReportDto);
            userReportMap.put(userId, userReportDto);
            userId++;
        }

    }


    /**
     * @param userId  This is the userid of associate
     * @param eventId This event is created for client evaluation and feedback.
     * @return will be returning all user report for that event .
     */
    @Override
    public UserReportDto getReportByUserId(long userId, String eventId) {
        return userReportMap.getOrDefault(userId, UserReportDto.builder().build());
    }

    /**
     * @param eventId This event is created for client evaluation and feedback.
     * @return will be returning user report for that event.
     */
    @Override
    public List<UserReportDto> getReportByEventId(String eventId) {
        return userReportMap.values().stream().toList();
    }

    /**
     * @return will be returning user reports.
     */
    @Override
    public List<UserReportDto> getReports() {
        return userReportMap.values().stream().toList();
    }
}
