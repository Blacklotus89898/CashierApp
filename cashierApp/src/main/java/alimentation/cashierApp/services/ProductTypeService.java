package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.ProductTypeRepository;
import alimentation.cashierApp.exception.CashierAppException;
import alimentation.cashierApp.models.ProductType;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository ProductTypeRepository;


    // Add methods for ProductType-related operations here
    public Iterable<ProductType> getAllProductTypes(){
        return ProductTypeRepository.findAll();
    }

    public Iterable<ProductType> getAllProductTypesByProductType(String productType){
        return ProductTypeRepository.findAllByProductType(productType);
    }

    public ProductType getProductTypeById(int id){
        Optional<ProductType> response = ProductTypeRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }


    public ProductType getProductTypeByName(String name){
        return ProductTypeRepository.findByName(name);
    }

    public ProductType addProductType(ProductType ProductType){
        return ProductTypeRepository.save(ProductType);
    }

    public ProductType updateProductType(ProductType ProductType){
        return ProductTypeRepository.save(ProductType);
    }

    public ProductType deleteProductType(int id){
        Optional<ProductType> target = ProductTypeRepository.findById(id);
        ProductType result = target.get();
        if (result == null){
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "ProductType missing");
        }
        ProductTypeRepository.deleteById(id);
        return result;
    }

    public void deleteAllProductTypes() {
        ProductTypeRepository.deleteAll();
    }

}
