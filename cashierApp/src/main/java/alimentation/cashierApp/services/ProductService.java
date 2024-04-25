package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.ProductRepository;
import alimentation.cashierApp.models.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;


    // Add methods for Product-related operations here
    Iterable<Product> getAllProducts(){
        return ProductRepository.findAll();
    }    
    
    // filtering method is inefficient and poorly synergized with the transaction id, query directly from the dao
    // List<Product> getAllProductsByTransactionId(int transactionId){
    //     Iterable<Product> allProduct = ProductRepository.findAll();
    //     List<Product> products = new ArrayList<>(); // Initialize the products list
    //     for (Product product : allProduct) {
    //         if (product.getTransaction().getIdNumber() == transactionId) {
    //             products.add(product);
    //         }
    //     }
    //     return products;
    // }

    Product getProductById(int id){
        Optional<Product> response = ProductRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addProduct(Product Product){
        ProductRepository.save(Product);
    }

    void updateProduct(Product Product){
        ProductRepository.save(Product);
    }

    void deleteProduct(int id){
        ProductRepository.deleteById(id);
    }
}
