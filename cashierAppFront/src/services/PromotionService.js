import axios from 'axios';

const API_URL = 'http://localhost:8080/promotions';

class PromotionService {
  getAllPromotions() {
    return axios.get(`${API_URL}/all`);
  }

  getPromotionById(id) {
    return axios.get(`${API_URL}`, { params: { id } });
  }

  createPromotion(promotionDto) {
    return axios.post(API_URL, promotionDto);
  }

  updatePromotion(promotionDto) {
    return axios.put(API_URL, promotionDto);
  }

  deletePromotion(id) {
    return axios.delete(`${API_URL}`, { params: { id } });
  }

  deleteAllPromotions() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new PromotionService();