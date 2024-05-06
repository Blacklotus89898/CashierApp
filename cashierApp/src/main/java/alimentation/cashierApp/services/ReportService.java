package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.ReportRepository;
import alimentation.cashierApp.exception.CashierAppException;
import alimentation.cashierApp.models.Employee;
import alimentation.cashierApp.models.Report;

@Service
public class ReportService {

    @Autowired
    private ReportRepository ReportRepository;

    @Autowired
    private EmployeeService employeeService;


    // Add methods for Report-related operations here
    public Iterable<Report> getAllReports() {
        return ReportRepository.findAll();
    }

    public Iterable<Report> getAllReportsByEmployeeId(int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return ReportRepository.findAllByEmployee(employee);
    }

    public Report getReportById(int id) {
        Optional<Report> response = ReportRepository.findById(id);
        if (response.isEmpty()) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Report missing");
        }
        return response.get();
    }

    public Report createReport(Report report){
        // error catchihng implemented in service layer temporarily, 
        // will be moved to a filtering, processing layer
        if (report.getEmployee() == null) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Employee missing");
        }
        
        return ReportRepository.save(report); //internal server error to be handled

    }

    public Report updateReport(Report report) {
        return ReportRepository.save(report);
    }

    public void deleteReport(int id) {
        Optional<Report> target = ReportRepository.findById(id);
        if (target.isEmpty()) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Report missing");
        }
        ReportRepository.deleteById(id);
    }

    public void deleteAllReports() {
        ReportRepository.deleteAll();
    }
}
