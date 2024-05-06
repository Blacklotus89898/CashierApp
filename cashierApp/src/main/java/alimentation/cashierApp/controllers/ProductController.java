package alimentation.cashierApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alimentation.cashierApp.dto.ProductDto;
import alimentation.cashierApp.models.Product;
import alimentation.cashierApp.services.ProductService;
import alimentation.cashierApp.services.ProductTypeService;
import alimentation.cashierApp.services.TransactionService;

@RestController
@RequestMapping("/products")
public class ProductController { //styling consistencty to be fixed

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/all")
    public Iterable<ProductDto> getAllProducts() {
        List<ProductDto> notesDtos = new ArrayList<>();
        Iterable<Product> target = productService.getAllProducts();
        target.forEach(note -> notesDtos.add(new ProductDto(note)));
        return  notesDtos;
    }

    @GetMapping("transaction/{transactionId}")
    public Iterable<ProductDto> getAllProductsByTransactionId(@PathVariable int transactionId) {
        List<ProductDto> notesDtos = new ArrayList<>();
        Iterable<Product> target = productService.getAllProductsByTransactionId(transactionId);
        target.forEach(note -> notesDtos.add(new ProductDto(note)));
        return notesDtos;
    }

    @GetMapping("productType/{productTypeId}")
    public Iterable<ProductDto> getAllProductsByProductTypeId(@PathVariable int productTypeId) {
        List<ProductDto> notesDtos = new ArrayList<>();
        Iterable<Product> target = productService.getAllProductsByProductTypeId(productTypeId);
        target.forEach(note -> notesDtos.add(new ProductDto(note)));
        return notesDtos;
    }

    @GetMapping()
    public ResponseEntity<Product> getProductById(@RequestParam("id") int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        Product product = toProduct(productDto);
        return new ProductDto(productService.addProduct(product));
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = toProduct(productDto);
        return new ProductDto(productService.updateProduct(product));
    }

    @DeleteMapping()
    public ProductDto deleteProduct(@RequestParam("id") int id) {
        return new ProductDto(productService.deleteProduct(id));
    }

    @DeleteMapping("/all")
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    private Product toProduct(ProductDto productDto) {
        return new Product(
        productDto.getIdNumber(),
         productDto.getQuantity(), 
         productTypeService.getProductTypeById(productDto.getProductTypeId()).getPrice(),
         productTypeService.getProductTypeById(productDto.getProductTypeId()), 
         transactionService.getTransactionById(productDto.getTransactionId())
        );
    }
}