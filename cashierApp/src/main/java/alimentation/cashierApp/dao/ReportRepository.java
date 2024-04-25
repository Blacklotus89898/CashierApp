package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;
import alimentation.cashierApp.models.Report;

public interface ReportRepository extends CrudRepository<Report, Integer>{
    
}
