package alimentation.cashierApp.dao;

import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.ProductType;

public interface ProductTypeRepository extends CrudRepository<ProductType, Integer>{
    
    Iterable<ProductType> findAllByProductType(String productType);

    ProductType findByName(String name);
}
