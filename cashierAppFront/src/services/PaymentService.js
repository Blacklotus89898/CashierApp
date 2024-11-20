import axios from 'axios';

const API_URL = 'http://localhost:8080/payments';

class PaymentService {
  getAllPayments() {
    return axios.get(`${API_URL}/all`);
  }

  getPaymentsByTransactionId(transactionId) {
    return axios.get(`${API_URL}/transaction/${transactionId}`);
  }

  getPaymentById(id) {
    return axios.get(`${API_URL}/${id}`);
  }

  createPayment(paymentDto) {
    return axios.post(API_URL, paymentDto);
  }

  updatePayment(paymentDto) {
    return axios.put(API_URL, paymentDto);
  }

  deletePayment(id) {
    return axios.delete(`${API_URL}/${id}`);
  }

  deleteAllPayments() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new PaymentService();