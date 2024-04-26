package alimentation.cashierApp.controllers;

import alimentation.cashierApp.dto.ReportDto;
import alimentation.cashierApp.models.Report;
import alimentation.cashierApp.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // @PostMapping
    // public ResponseEntity<ReportDto> createReport(@RequestBody ReportDto reportDto) {
    //     Report report = reportService.createReport(reportDto.toReport());
    //     return ResponseEntity.ok(new ReportDto(report));
    // }

    @GetMapping("/all")
    public ResponseEntity<List<ReportDto>> getAllReports() {
        List<Report> reports = (List<Report>) reportService.getAllReports();
        List<ReportDto> reportDtos = reports.stream()
                .map(ReportDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reportDtos);
    }

    @GetMapping
    public ResponseEntity<ReportDto> getReportById(@RequestParam("id") int id) {
        Report report = reportService.getReportById(id);
        return ResponseEntity.ok(new ReportDto(report));
    }

    @PutMapping
    public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto) {
        Report report = reportService.updateReport(reportDto.toReport());
        return ResponseEntity.ok(new ReportDto(report));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReport(@RequestParam("id") int id) {
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }

    // private ReportDto toReportDto(Report report) {
    //     return new ReportDto(report.getIdNumber(), report.getName(), report.getPrivilege());
    // }

    // private Report toReport(ReportDto reportDto) {
    //     return new Report(reportDto.getIdNumber(), reportDto.getName(), reportDto.getPrivilege());
    // }
}