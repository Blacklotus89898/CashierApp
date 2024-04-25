package alimentation.cashierApp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import alimentation.cashierApp.dao.ReportRepository;
import alimentation.cashierApp.models.Report;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportService reportService;

    @Test
    public void testGetAllReports() {
        reportService.getAllReports();
        verify(reportRepository, times(1)).findAll();
    }

    @Test
    public void testGetReportById() {
        Report report = new Report();
        report.setIdNumber(1);
        when(reportRepository.findById(1)).thenReturn(Optional.of(report));

        Report result = reportService.getReportById(1);
        assertEquals(report, result);
    }

    @Test
    public void testAddReport() {
        Report report = new Report();
        reportService.addReport(report);
        verify(reportRepository, times(1)).save(report);
    }

    @Test
    public void testUpdateReport() {
        Report report = new Report();
        reportService.updateReport(report);
        verify(reportRepository, times(1)).save(report);
    }

    @Test
    public void testDeleteReport() {
        reportService.deleteReport(1);
        verify(reportRepository, times(1)).deleteById(1);
    }
}