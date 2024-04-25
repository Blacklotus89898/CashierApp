package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.ReportRepository;
import alimentation.cashierApp.models.Report;

@Service
public class ReportService {

    @Autowired
    private ReportRepository ReportRepository;


    // Add methods for Report-related operations here
    Iterable<Report> getAllReports(){
        return ReportRepository.findAll();
    }

    Report getReportById(int id){
        Optional<Report> response = ReportRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addReport(Report Report){
        ReportRepository.save(Report);
    }

    void updateReport(Report Report){
        ReportRepository.save(Report);
    }

    void deleteReport(int id){
        ReportRepository.deleteById(id);
    }
}
