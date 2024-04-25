package alimentation.cashierApp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import alimentation.cashierApp.dao.PaymentRepository;
import alimentation.cashierApp.models.Payment;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testGetAllPayments() {
        paymentService.getAllPayments();
        verify(paymentRepository, times(1)).findAll();
    }

    @Test
    public void testGetPaymentById() {
        Payment payment = new Payment();
        payment.setIdNumber(1);
        when(paymentRepository.findById(1)).thenReturn(Optional.of(payment));

        Payment result = paymentService.getPaymentById(1);
        assertEquals(payment, result);
    }

    @Test
    public void testAddPayment() {
        Payment payment = new Payment();
        paymentService.addPayment(payment);
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    public void testUpdatePayment() {
        Payment payment = new Payment();
        paymentService.updatePayment(payment);
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    public void testDeletePayment() {
        paymentService.deletePayment(1);
        verify(paymentRepository, times(1)).deleteById(1);
    }
}