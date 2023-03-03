package com.yash.ems.report.service;

import com.yash.ems.report.dto.UserReportDto;

import java.util.List;
/**
 * This interface is used to define api specifications for report module.
 * @author prachi.kurhe
 * @since 01--3-2023
 */
public interface ReportService {

    UserReportDto getReportByUserId(long userId, String eventId);

    List<UserReportDto> getReportByEventId(String eventId);

    List<UserReportDto> getReports();

}
