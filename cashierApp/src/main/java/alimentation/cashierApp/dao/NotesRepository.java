package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Notes;
import alimentation.cashierApp.models.Report;

//jpa repository is a type of crud repository with more features
public interface NotesRepository extends CrudRepository<Notes, Integer>{ 

    Iterable<Notes> findAllByReport(Report report);
    
}

