package alimentation.cashierApp.controllers;

import alimentation.cashierApp.dto.ReportDto;
import alimentation.cashierApp.models.Report;
import alimentation.cashierApp.services.EmployeeService;
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
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<ReportDto>> getAllReports() {
        try {
            List<Report> reports = (List<Report>) reportService.getAllReports();
            List<ReportDto> reportDtos = reports.stream()
                    .map(ReportDto::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(reportDtos);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<List<ReportDto>> getAllByEmployeeId(@RequestParam("employeeId") int employeeId) {
        try {
            List<Report> reports = (List<Report>) reportService.getAllReportsByEmployeeId(employeeId);
            List<ReportDto> reportDtos = reports.stream()
                    .map(ReportDto::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(reportDtos);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<ReportDto> getReportById(@RequestParam("id") int id) {
        try {
            Report report = reportService.getReportById(id);
            return ResponseEntity.ok(new ReportDto(report));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping
    public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto) {
        try {
            Report report = reportService.updateReport(toReport(reportDto));
            return ResponseEntity.ok(new ReportDto(report));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReport(@RequestParam("id") int id) {
        try {
            reportService.deleteReport(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllReports() {
        try {
            reportService.deleteAllReports();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    private Report toReport(ReportDto reportDto) {
        return new Report(reportDto.getIdNumber(), reportDto.getDate(), reportDto.getStart(), reportDto.getEnd(), employeeService.getEmployeeById(reportDto.getEmployeeId()));
    }
}