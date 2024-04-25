package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.ProductTypeRepository;
import alimentation.cashierApp.models.ProductType;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository ProductTypeRepository;


    // Add methods for ProductType-related operations here
    Iterable<ProductType> getAllProductTypes(){
        return ProductTypeRepository.findAll();
    }

    ProductType getProductTypeById(int id){
        Optional<ProductType> response = ProductTypeRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addProductType(ProductType ProductType){
        ProductTypeRepository.save(ProductType);
    }

    void updateProductType(ProductType ProductType){
        ProductTypeRepository.save(ProductType);
    }

    void deleteProductType(int id){
        ProductTypeRepository.deleteById(id);
    }

    // void deleteAllProductTypes(){
    //     ProductTypeRepository.deleteAll();
    // }
}
