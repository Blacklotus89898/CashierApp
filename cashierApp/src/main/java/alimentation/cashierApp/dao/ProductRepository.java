package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Product;
import alimentation.cashierApp.models.ProductType;
import alimentation.cashierApp.models.Transaction;

public interface ProductRepository extends CrudRepository<Product, Integer>{
    
    Iterable<Product> findAllByTransaction(Transaction transaction);

    Iterable<Product> findAllByProductType(ProductType productType);

}

