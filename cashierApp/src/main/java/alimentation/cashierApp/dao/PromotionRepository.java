package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Promotion;

public interface PromotionRepository extends CrudRepository<Promotion, Integer>{
    
}

