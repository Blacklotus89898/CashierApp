import axios from 'axios';

const API_URL = 'http://localhost:8080/productTypes';

class ProductTypeService {
  getAllProductTypes() {
    return axios.get(`${API_URL}/all`);
  }

  getProductTypeById(id) {
    return axios.get(`${API_URL}`, { params: { id } });
  }

  getAllProductTypesByProductType(productType) {
    return axios.get(`${API_URL}/productType`, { params: { productType } });
  }

  createProductType(productTypeDto) {
    return axios.post(API_URL, productTypeDto);
  }

  updateProductType(productTypeDto) {
    return axios.put(API_URL, productTypeDto);
  }

  deleteProductType(id) {
    return axios.delete(`${API_URL}`, { params: { id } });
  }

  deleteAllProductTypes() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new ProductTypeService();