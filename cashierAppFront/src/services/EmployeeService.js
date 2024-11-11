import axios from 'axios';

const API_URL = 'http://localhost:8080/employees';

class EmployeeService {
  getAllEmployees() {
    return axios.get(`${API_URL}/all`);
  }

  getEmployeeById(id) {
    return axios.get(`${API_URL}`, { params: { id } });
  }

  getEmployeeByName(name) {
    return axios.get(`${API_URL}/name`, { params: { name } });
  }

  createEmployee(employeeDto) {
    return axios.post(`${API_URL}`, employeeDto);
  }

  updateEmployee(employeeDto) {
    return axios.put(`${API_URL}`, employeeDto);
  }

  deleteEmployee(id) {
    return axios.delete(`${API_URL}`, { params: { id } });
  }

  deleteAllEmployees() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new EmployeeService();