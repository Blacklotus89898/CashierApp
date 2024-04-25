package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
    
}

