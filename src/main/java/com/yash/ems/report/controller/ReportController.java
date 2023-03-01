package com.yash.ems.report.controller;

import com.yash.ems.report.dto.UserReportDto;
import com.yash.ems.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    /**
     *
     * @param userId This is the unique id of associate.

     * This Api s used to return user report associated to provided event by user id.\n
     * @param eventId This is the event created for particular client.\n
     *                event is combination of evaluation card and users required to evaluate base\n
     *                there performance.
     * @return This will return user of report */
    @GetMapping("/{userId}")
    public UserReportDto getReportByUserId(@PathVariable("userId") long userId,
                                           @RequestParam(value = "eventId", required = false) String eventId){
        return reportService.getReportByUserId(userId, eventId);
    }

    /**
     * This Api s used to return All report associated to provided event.\n
     * Or all user reports will be return.
     * @param eventId This is the event created for particular client.\n
     *                event is combination of evaluation card and users required to evaluate base\n
     *                there performance.
     * @return This will return list of reports
     */
    @GetMapping
    public List<UserReportDto> getReports(@RequestParam(value = "eventId", required = false) String eventId) {
    return isNotBlank(eventId) ?
            reportService.getReportByEventId(eventId) :
            reportService.getReports();
    }

}
