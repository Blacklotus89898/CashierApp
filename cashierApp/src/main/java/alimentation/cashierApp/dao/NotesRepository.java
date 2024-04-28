package alimentation.cashierApp.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import alimentation.cashierApp.models.Notes;
import alimentation.cashierApp.models.Report;

//jpa repository is a type of crud repository with more features
public interface NotesRepository extends JpaRepository<Notes, Integer>{ 

    // @Query("select n from Notes n where n.report_id_number like %?1")
    // Iterable<Notes> findAllByReportId(int reportId);
    Iterable<Notes> findAllByReport(Report report);
    
}

