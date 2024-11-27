package alimentation.cashierApp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import alimentation.cashierApp.dao.ProductRepository;
import alimentation.cashierApp.models.Product;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        productService.getAllProducts();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setIdNumber(1);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1);
        assertEquals(product, result);
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        productService.addProduct(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        productService.updateProduct(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testDeleteProduct() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(new Product()));

        productService.deleteProduct(1);
        verify(productRepository, times(1)).deleteById(1);
    }
}