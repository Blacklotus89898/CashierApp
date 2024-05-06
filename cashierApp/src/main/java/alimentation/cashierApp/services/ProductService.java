package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.ProductRepository;
import alimentation.cashierApp.exception.CashierAppException;
import alimentation.cashierApp.models.Product;
import alimentation.cashierApp.models.ProductType;
import alimentation.cashierApp.models.Transaction;

@Service
public class ProductService { //requires error catching

    @Autowired
    private ProductRepository ProductRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ProductTypeService productTypeService;


    // Add methods for Product-related operations here
    public Iterable<Product> getAllProducts(){
        return ProductRepository.findAll();
    }   

    public Iterable<Product> getAllProductsByTransactionId(int transactionId){
        Transaction transaction = transactionService.getTransactionById(transactionId);
        return ProductRepository.findAllByTransaction(transaction);
    }

    
    public Iterable<Product> getAllProductsByProductTypeId(int productTypeId) {
        ProductType productType = productTypeService.getProductTypeById(productTypeId);
        return ProductRepository.findAllByProductType(productType);
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

    public Product getProductById(int id){
        Optional<Product> response = ProductRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    public Product addProduct(Product Product){
        return ProductRepository.save(Product);
    }

    public Product updateProduct(Product Product){
        return ProductRepository.save(Product);
    }

    public Product deleteProduct(int id){
        Optional<Product> target = ProductRepository.findById(id);
        Product result = target.get();
        if (result == null){
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Product missing");
        }
        ProductRepository.deleteById(id);
        return result;
    }

    public void deleteAllProducts() {
        ProductRepository.deleteAll();
    }

}
