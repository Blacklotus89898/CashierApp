package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.PaymentRepository;
import alimentation.cashierApp.models.Payment;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository PaymentRepository;


    // Add methods for Payment-related operations here
    Iterable<Payment> getAllPayments(){
        return PaymentRepository.findAll();
    }

    Payment getPaymentById(int id){
        Optional<Payment> response = PaymentRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addPayment(Payment Payment){
        PaymentRepository.save(Payment);
    }

    void updatePayment(Payment Payment){
        PaymentRepository.save(Payment);
    }

    void deletePayment(int id){
        PaymentRepository.deleteById(id);
    }
}
