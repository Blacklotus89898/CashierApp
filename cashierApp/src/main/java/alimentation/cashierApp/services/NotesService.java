package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.NotesRepository;
import alimentation.cashierApp.exception.CashierAppException;
import alimentation.cashierApp.models.Notes;
import alimentation.cashierApp.models.Report;

@Service
public class NotesService {

    @Autowired
    private NotesRepository NotesRepository;
    @Autowired
    private ReportService reportService; //use service not dao

    // Add methods for Notes-related operations here
    public Iterable<Notes> getAllNotes() {
        return NotesRepository.findAll();
    }

    public Iterable<Notes> getAllNotesByReportId(int reportId) {
        Report report = reportService.getReportById(reportId);
        if (report == null) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Report missing");
        }
        return NotesRepository.findAllByReport(report);
    }

    public Notes getNotesById(int id) {
        Optional<Notes> response = NotesRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    public Notes addNotes(Notes Notes) {
        return NotesRepository.save(Notes);
    }

    public Notes updateNotes(Notes Notes) {
        return NotesRepository.save(Notes);
    }

    public Notes deleteNotes(int id) { //get the deleted item in case of mistake
        Optional<Notes> note = NotesRepository.findById(id);
        if (note.get() == null){
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Notes missing");
        }
        NotesRepository.deleteById(id);
        return note.get();
    }
}
