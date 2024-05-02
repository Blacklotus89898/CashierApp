package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.ProductType;
import alimentation.cashierApp.models.Promotion;

public interface PromotionRepository extends CrudRepository<Promotion, Integer>{

    Promotion findByProductType(ProductType productType);
    
}

