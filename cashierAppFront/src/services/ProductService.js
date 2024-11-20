import axios from 'axios';

const API_URL = 'http://localhost:8080/products';

class ProductService {
  getAllProducts() {
    return axios.get(`${API_URL}/all`);
  }

  getProductsByTransactionId(transactionId) {
    return axios.get(`${API_URL}/transaction/${transactionId}`);
  }

  getProductsByProductTypeId(productTypeId) {
    return axios.get(`${API_URL}/productType/${productTypeId}`);
  }

  getProductById(id) {
    return axios.get(`${API_URL}`, { params: { id } });
  }

  createProduct(productDto) {
    return axios.post(API_URL, productDto);
  }

  updateProduct(productDto) {
    return axios.put(API_URL, productDto);
  }

  deleteProduct(id) {
    return axios.delete(`${API_URL}`, { params: { id } });
  }

  deleteAllProducts() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new ProductService();