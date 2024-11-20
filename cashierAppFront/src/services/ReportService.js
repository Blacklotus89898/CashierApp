import axios from 'axios';

const API_URL = 'http://localhost:8080/reports';

class ReportService {
  getAllReports() {
    return axios.get(`${API_URL}/all`);
  }

  getReportsByEmployeeId(employeeId) {
    return axios.get(`${API_URL}/employee`, { params: { employeeId } });
  }

  getReportById(id) {
    return axios.get(`${API_URL}`, { params: { id } });
  }

  createReport(reportDto) {
    return axios.post(API_URL, reportDto);
  }

  updateReport(reportDto) {
    return axios.put(API_URL, reportDto);
  }

  deleteReport(id) {
    return axios.delete(API_URL, { params: { id } });
  }

  deleteAllReports() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new ReportService();