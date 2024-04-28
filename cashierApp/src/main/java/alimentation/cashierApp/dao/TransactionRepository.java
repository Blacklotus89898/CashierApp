package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Transaction;
import alimentation.cashierApp.models.Report;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
    
        Iterable<Transaction> findAllByReport(Report report);

}

