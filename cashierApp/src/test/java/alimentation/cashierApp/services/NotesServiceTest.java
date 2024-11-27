package alimentation.cashierApp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import alimentation.cashierApp.dao.NotesRepository;
import alimentation.cashierApp.dao.ReportRepository;
import alimentation.cashierApp.models.Notes;
import alimentation.cashierApp.models.Report;

import java.util.Collection;

public class NotesServiceTest {

    @InjectMocks
    NotesService notesService;

    @Mock
    ReportService reportService;

    @Mock
    NotesRepository notesRepository;
    @Mock
    ReportRepository reportRepository; 

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllNotesTest() {
        when(notesRepository.findAll()).thenReturn(Arrays.asList(new Notes(), new Notes()));
        assertEquals(2, ((Collection<?>) notesService.getAllNotes()).size());
    }

    @Test
    public void getAllNotesByReportIdTest() {
        Report report = new Report(); // create a Report object
        when(reportRepository.findById(anyInt())).thenReturn(Optional.of(report)); // mock the ReportRepository
        when(notesRepository.findAllByReport(report)).thenReturn(Arrays.asList(new Notes()));
        when(reportService.getReportById(1)).thenReturn(report);
        assertEquals(1, ((Collection<?>) notesService.getAllNotesByReportId(1)).size());
    }

    @Test
    public void getNotesByIdTest() {
        when(notesRepository.findById(anyInt())).thenReturn(Optional.of(new Notes()));
        assertEquals(new Notes().getIdNumber(), notesService.getNotesById(1).getIdNumber());
    }

    @Test
    public void addNotesTest() {
        Notes notes = new Notes();
        notesService.addNotes(notes);
        verify(notesRepository, times(1)).save(notes);
    }

    @Test
    public void updateNotesTest() {
        Notes notes = new Notes();
        notesService.updateNotes(notes);
        verify(notesRepository, times(1)).save(notes);
    }

    @Test
    public void deleteNotesTest() {
        when(notesRepository.findById(anyInt())).thenReturn(Optional.of(new Notes()));
        notesService.deleteNotes(1);
        verify(notesRepository, times(1)).deleteById(1);
    }
}