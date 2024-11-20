import axios from 'axios';

const API_URL = 'http://localhost:8080/transactions';

class TransactionService {
  getAllTransactions() {
    return axios.get(`${API_URL}/all`);
  }

  getTransactionsByReportId(reportId) {
    return axios.get(`${API_URL}/report/${reportId}`);
  }

  getTransactionById(id) {
    return axios.get(`${API_URL}`, { params: { id } });
  }

  createTransaction(transactionDto) {
    return axios.post(API_URL, transactionDto);
  }

  updateTransaction(transactionDto) {
    return axios.put(API_URL, transactionDto);
  }

  deleteTransaction(id) {
    return axios.delete(`${API_URL}`, { params: { id } });
  }

  deleteAllTransactions() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new TransactionService();