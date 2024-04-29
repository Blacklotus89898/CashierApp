package alimentation.cashierApp.services;

import java.util.Optional;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.TransactionRepository;
import alimentation.cashierApp.models.Report;
import alimentation.cashierApp.models.Transaction;

@Service
public class TransactionService { //major fix needed here, should not allow another repository to be injected
    // call from the service class I think

    @Autowired
    private TransactionRepository TransactionRepository;
    // @Autowired
    // private ReportRepository reportRepository;

    @Autowired
    private ReportService reportService;


    // Add methods for Transaction-related operations here
    public Iterable<Transaction> getAllTransactions(){
        return TransactionRepository.findAll();
    }

    public Iterable<Transaction> getAllTransactionsByReportId(int reportId){
        Report report = reportService.getReportById(reportId);
        // Report report = reportRepository.findById(reportId).orElse(null);
        if (report != null) {
            return TransactionRepository.findAllByReport(report);
        }
        return new ArrayList<>(); // or throw an exception
    }

    public Transaction getTransactionById(int id){
        Optional<Transaction> response = TransactionRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    public Transaction addTransaction(Transaction Transaction){
        return TransactionRepository.save(Transaction);
    }

    public Transaction updateTransaction(Transaction Transaction){
        return TransactionRepository.save(Transaction);
    }

    public void deleteTransaction(int id){
        TransactionRepository.deleteById(id);
    }
}
