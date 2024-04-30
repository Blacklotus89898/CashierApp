package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Payment;
import alimentation.cashierApp.models.Transaction;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

    Iterable<Payment> findAllByTransaction(Transaction transaction);
    
}

