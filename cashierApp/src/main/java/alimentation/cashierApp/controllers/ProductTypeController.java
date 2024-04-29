package alimentation.cashierApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alimentation.cashierApp.dto.ProductTypeDto;
import alimentation.cashierApp.models.ProductType;
import alimentation.cashierApp.services.ProductTypeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productTypes")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductTypeDto>> getAllProductTypes() {
        List<ProductTypeDto> productTypeDtos = new ArrayList<>();
        productTypeService.getAllProductTypes()
                .forEach(productType -> productTypeDtos.add(new ProductTypeDto(productType)));
        return new ResponseEntity<>(productTypeDtos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ProductTypeDto> getProductTypeById(@RequestParam("id") int id) {
        ProductType productType = productTypeService.getProductTypeById(id);
        if (productType != null) {
            return new ResponseEntity<>(new ProductTypeDto(productType), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/productType") //require severe renaming to category
    public ResponseEntity<List<ProductTypeDto>> getAllProductTypesByProductType(@RequestParam("productType") String productType) {
        List<ProductTypeDto> productTypeDtos = new ArrayList<>();
        productTypeService.getAllProductTypesByProductType(productType)
                .forEach(productTypes -> productTypeDtos.add(new ProductTypeDto(productTypes)));
        return new ResponseEntity<>(productTypeDtos, HttpStatus.OK);
    }
    
    @GetMapping("/name")
    public ResponseEntity<ProductTypeDto> getProductTypeByName(@RequestParam("name") String name) {
        ProductType productType = productTypeService.getProductTypeByName(name);
        if (productType != null) {
            return new ResponseEntity<>(new ProductTypeDto(productType), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping //need error check to avoid duplicate names
    public ResponseEntity<ProductTypeDto> addProductType(@RequestBody ProductTypeDto productTypeDto) {
        ProductType productType = productTypeService.addProductType(productTypeDto.toProductType());
        return new ResponseEntity<>(new ProductTypeDto(productType), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductTypeDto> updateProductType(@RequestBody ProductTypeDto productTypeDto) {
        ProductType result = productTypeService.updateProductType(productTypeDto.toProductType());
        return new ResponseEntity<>(new ProductTypeDto(result), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProductType(@RequestParam("id") int id) {
        productTypeService.deleteProductType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}