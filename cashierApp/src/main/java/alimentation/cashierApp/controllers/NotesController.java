package alimentation.cashierApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alimentation.cashierApp.dto.NotesDto;
import alimentation.cashierApp.models.Notes;
import alimentation.cashierApp.services.NotesService;
import alimentation.cashierApp.services.ReportService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;
    @Autowired
    private ReportService reportService;

    @GetMapping("/all")
    public ResponseEntity<List<NotesDto>> getAllNotes() {
        try {
            List<Notes> notes = new ArrayList<>();
            notesService.getAllNotes().forEach(notes::add);
            List<NotesDto> notesDtos = notes.stream()
                    .map(NotesDto::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(notesDtos);
        } catch (Exception e) {
            NotesDto errorDto = new NotesDto();
            errorDto.setMessage("Error: " + e.getMessage());
            List<NotesDto> errorList = List.of(errorDto);
            return ResponseEntity.status(500).body(errorList);
        }
    }

    @GetMapping
    public ResponseEntity<NotesDto> getNotesById(@RequestParam("id") int id) {
        try {
            Notes note = notesService.getNotesById(id);
            return ResponseEntity.ok(new NotesDto(note));
        } catch (Exception e) {
            NotesDto errorDto = new NotesDto();
            errorDto.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(errorDto);
        }
    }

    @GetMapping("report/{reportId}")
    public ResponseEntity<List<NotesDto>> getNotesByReportId(@PathVariable int reportId) {
        try {
            List<Notes> notes = new ArrayList<>();
            notesService.getAllNotesByReportId(reportId).forEach(notes::add);
            List<NotesDto> notesDtos = notes.stream()
                    .map(NotesDto::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(notesDtos);
        } catch (Exception e) {
            NotesDto errorDto = new NotesDto();
            errorDto.setMessage("Error: " + e.getMessage());
            List<NotesDto> errorList = List.of(errorDto);
            return ResponseEntity.status(500).body(errorList);
        }
    }

    @PostMapping
    public ResponseEntity<NotesDto> addNotes(@RequestBody NotesDto notesDto) {
        try {
            Notes note = notesService.addNotes(toNotes(notesDto));
            return ResponseEntity.status(201).body(new NotesDto(note));
        } catch (Exception e) {
            NotesDto errorDto = new NotesDto();
            errorDto.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(errorDto);
        }
    }

    @PutMapping
    public ResponseEntity<NotesDto> updateNotes(@RequestBody NotesDto notesDto) {
        try {
            Notes note = toNotes(notesDto);
            return ResponseEntity.ok(new NotesDto(notesService.updateNotes(note)));
        } catch (Exception e) {
            NotesDto errorDto = new NotesDto();
            errorDto.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(errorDto);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteNotes(@RequestParam("id") int id) {
        try {
            notesService.deleteNotes(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("all")
    public ResponseEntity<String> deleteAllNotes() {
        try {
            notesService.deleteAllNotes();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    private Notes toNotes(NotesDto notesDto) {
        return new Notes(notesDto.getIdNumber(), notesDto.getMessage(), notesDto.getTime(), reportService.getReportById(notesDto.getReportId()));
    }
}