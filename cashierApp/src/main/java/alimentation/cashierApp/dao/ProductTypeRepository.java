package alimentation.cashierApp.dao;

import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.ProductType;

public interface ProductTypeRepository extends CrudRepository<ProductType, Integer>{
    
}
