package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Notes;

public interface NotesRepository extends CrudRepository<Notes, Integer>{
    
}

