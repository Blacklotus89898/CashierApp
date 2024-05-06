package alimentation.cashierApp.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alimentation.cashierApp.dto.PaymentDto;
import alimentation.cashierApp.models.Payment;
import alimentation.cashierApp.models.Transaction;
import alimentation.cashierApp.services.PaymentService;
import alimentation.cashierApp.services.TransactionService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/all")
    public Iterable<PaymentDto> getAllPayments() {
        ArrayList<PaymentDto> paymentsDtos = new ArrayList<>();
        Iterable<Payment> target = paymentService.getAllPayments();
        target.forEach(payment -> paymentsDtos.add(new PaymentDto(payment)));
        return paymentsDtos;
    }

    @GetMapping("/transaction/{transactionId}")
    public Iterable<PaymentDto> getAllPaymentsByTransactionId(@PathVariable int transactionId) {
        ArrayList<PaymentDto> paymentsDtos = new ArrayList<>();
        Iterable<Payment> target = paymentService.getAllPaymentsByTransactionId(transactionId);
        target.forEach(payment -> paymentsDtos.add(new PaymentDto(payment)));
        return paymentsDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable int id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new PaymentDto(payment), HttpStatus.OK);
        }
    }

    // @PostMapping
    // public Payment addPayment(@RequestBody Payment payment) {
    //     return paymentService.addPayment(payment);
    // }

    @PutMapping()
    public PaymentDto updatePayment(@RequestBody PaymentDto paymentDto) {
            return new PaymentDto(paymentService.updatePayment(toPayemnt(paymentDto)));

    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDto> deletePayment(@PathVariable int id) {
        Payment payment = paymentService.deletePayment(id);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new PaymentDto(payment), HttpStatus.OK);
        }
    }

    @DeleteMapping("/all")
    public void deleteAllPayments() {
        paymentService.deleteAllPayments();
    }

    private Payment toPayemnt(PaymentDto paymentDto) {
        Transaction transaction = transactionService.getTransactionById(paymentDto.getTransactionId());
        return new Payment(paymentDto.getIdNumber(), paymentDto.getPaymentType() , paymentDto.getAmount(), transaction);
    }
}