package com.yash.ems.report.service;

import com.yash.ems.report.dto.UserReportDto;

import java.util.List;

public interface ReportService {

    UserReportDto getReportByUserId(long userId, String eventId);

    List<UserReportDto> getReportByEventId(String eventId);

    List<UserReportDto> getReports();

}
