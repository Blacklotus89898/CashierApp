package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
    
}

