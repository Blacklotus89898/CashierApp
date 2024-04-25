package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.TransactionRepository;
import alimentation.cashierApp.models.Transaction;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository TransactionRepository;


    // Add methods for Transaction-related operations here
    Iterable<Transaction> getAllTransactions(){
        return TransactionRepository.findAll();
    }

    Transaction getTransactionById(int id){
        Optional<Transaction> response = TransactionRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addTransaction(Transaction Transaction){
        TransactionRepository.save(Transaction);
    }

    void updateTransaction(Transaction Transaction){
        TransactionRepository.save(Transaction);
    }

    void deleteTransaction(int id){
        TransactionRepository.deleteById(id);
    }
}
