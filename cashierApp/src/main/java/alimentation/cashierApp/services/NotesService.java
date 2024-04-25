package alimentation.cashierApp.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.NotesRepository;
import alimentation.cashierApp.dao.ReportRepository;
import alimentation.cashierApp.models.Notes;
import alimentation.cashierApp.models.Report;

@Service
public class NotesService {

    @Autowired
    private NotesRepository NotesRepository;
    @Autowired
    private ReportRepository reportRepository;

    // Add methods for Notes-related operations here
    Iterable<Notes> getAllNotes() {
        return NotesRepository.findAll();
    }

    Iterable<Notes> getAllNotesByReportId(int reportId) {
        Report report = reportRepository.findById(reportId).orElse(null);
        if (report != null) {
            return NotesRepository.findAllByReport(report);
        }
        return new ArrayList<>(); // or throw an exception
    }

    Notes getNotesById(int id) {
        Optional<Notes> response = NotesRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addNotes(Notes Notes) {
        NotesRepository.save(Notes);
    }

    void updateNotes(Notes Notes) {
        NotesRepository.save(Notes);
    }

    void deleteNotes(int id) {
        NotesRepository.deleteById(id);
    }
}
