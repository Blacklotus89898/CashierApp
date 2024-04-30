package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.PaymentRepository;
import alimentation.cashierApp.exception.CashierAppException;
import alimentation.cashierApp.models.Payment;
import alimentation.cashierApp.models.Transaction;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository PaymentRepository;
    @Autowired
    private TransactionService transactionService;


    // Add methods for Payment-related operations here
    public Iterable<Payment> getAllPayments(){
        return PaymentRepository.findAll();
    }

    public Payment getPaymentById(int id){
        Optional<Payment> response = PaymentRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    public Iterable<Payment> getAllPaymentsByTransactionId(int transactionId){
        Transaction transaction = transactionService.getTransactionById(transactionId);
        return PaymentRepository.findAllByTransaction(transaction);
    }

    public Payment addPayment(Payment Payment){
        return PaymentRepository.save(Payment);
    }

    public Payment updatePayment(Payment Payment){
        return PaymentRepository.save(Payment);
    }

    public Payment deletePayment(int id){
        Payment target = PaymentRepository.findById(id).get();
        if (target == null){
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Payment missing");
        }
        PaymentRepository.deleteById(id);
        return target;
    }
}
