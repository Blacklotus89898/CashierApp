import axios from 'axios';

const API_URL = 'http://localhost:8080/notes';

class NotesService {
  getAllNotes() {
    return axios.get(`${API_URL}/all`);
  }

  getNotesById(id) {
    return axios.get(`${API_URL}`, { params: { id } });
  }

  createNotes(notesDto) {
    return axios.post(API_URL, notesDto);
  }

  updateNotes(notesDto) {
    return axios.put(API_URL, notesDto);
  }

  deleteNotes(id) {
    return axios.delete(`${API_URL}`, { params: { id } });
  }

  deleteAllNotes() {
    return axios.delete(`${API_URL}/all`);
  }
}

export default new NotesService();