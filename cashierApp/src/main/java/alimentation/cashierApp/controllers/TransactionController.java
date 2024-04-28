package alimentation.cashierApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alimentation.cashierApp.dto.TransactionDto;
import alimentation.cashierApp.models.Report;
import alimentation.cashierApp.models.Transaction;
import alimentation.cashierApp.services.ReportService;
import alimentation.cashierApp.services.TransactionService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ReportService reportService;

    @GetMapping("/all")
    public List<TransactionDto> getAllTransactions() {
        Iterable<Transaction> transactions = transactionService.getAllTransactions();
        return StreamSupport.stream(transactions.spliterator(), false)
                .map(TransactionDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{reportId}")
    public List<TransactionDto> getAllTransactionsByReportId(@PathVariable int reportId) {
        Iterable<Transaction> transactions = transactionService.getAllTransactionsByReportId(reportId);
        return StreamSupport.stream(transactions.spliterator(), false)
                .map(TransactionDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping
    public ResponseEntity<TransactionDto> getTransactionById(@RequestParam("id") int id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new TransactionDto(transaction), HttpStatus.OK);
        }
    }

    @PostMapping
    public TransactionDto addTransaction(@RequestBody TransactionDto transactionDto) {
        Report report = reportService.getReportById(transactionDto.getReportId());
        Transaction newTransaction = new Transaction(transactionDto.getIdNumber(), transactionDto.getTime(), transactionDto.getTransactiontype(), report);
        return new TransactionDto(transactionService.addTransaction(newTransaction));
    }
    
    @PutMapping
    public TransactionDto updateTransaction(@RequestBody TransactionDto transactionDto) {
        Report report = reportService.getReportById(transactionDto.getReportId());
        Transaction newTransaction = new Transaction(transactionDto.getIdNumber(), transactionDto.getTime(), transactionDto.getTransactiontype(), report);
        return new TransactionDto(transactionService.updateTransaction(newTransaction));
    }

    @DeleteMapping
    public void deleteTransaction(@RequestParam("id") int id) {
        transactionService.deleteTransaction(id);
    }
}