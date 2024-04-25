package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{
    
}

