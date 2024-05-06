package alimentation.cashierApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alimentation.cashierApp.dto.NotesDto;
import alimentation.cashierApp.models.Notes;
import alimentation.cashierApp.services.NotesService;
import alimentation.cashierApp.services.ReportService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;
    @Autowired
    private ReportService reportService;

    @GetMapping("/all")
    public ResponseEntity<List<NotesDto>> getAllNotes() {
        List<NotesDto> notesDtos = new ArrayList<>();
        notesService.getAllNotes().forEach(note -> notesDtos.add(new NotesDto(note)));
        return new ResponseEntity<>(notesDtos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<NotesDto> getNotesById(@RequestParam("id") int id) {
        Notes note = notesService.getNotesById(id);
        if (note != null) {
            NotesDto result = new NotesDto(note);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("report/{reportId}")
    public ResponseEntity<List<NotesDto>> getNotesByReportId(@PathVariable int reportId) {
        List<NotesDto> notesDtos = new ArrayList<>();
        notesService.getAllNotesByReportId(reportId).forEach(note -> notesDtos.add(new NotesDto(note)));
        return new ResponseEntity<>(notesDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NotesDto> addNotes(@RequestBody NotesDto notesDto) {
        Notes note = notesService.addNotes(toNotes(notesDto));
        NotesDto result = new NotesDto(note);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<NotesDto> updateNotes(@RequestBody NotesDto notesDto) {
        Notes note = toNotes(notesDto);
        NotesDto result = new NotesDto(notesService.updateNotes(note));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping    
    public ResponseEntity<NotesDto> deleteNotes(@RequestParam("id") int id) {
        NotesDto result = new NotesDto(notesService.deleteNotes(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("all")
    public void deleteAllNotes() {
        notesService.deleteAllNotes();
    }

    private Notes toNotes(NotesDto notesDto) {
        return new Notes(notesDto.getIdNumber(), notesDto.getMessage(), notesDto.getTime(), reportService.getReportById(notesDto.getReportId()));
    }
}