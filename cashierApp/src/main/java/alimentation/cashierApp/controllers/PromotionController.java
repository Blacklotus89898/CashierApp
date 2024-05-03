package alimentation.cashierApp.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import alimentation.cashierApp.dto.PromotionDto;
import alimentation.cashierApp.models.Promotion;
import alimentation.cashierApp.services.ProductTypeService;
import alimentation.cashierApp.services.PromotionService;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public Iterable<PromotionDto> getAllPromotions() {
        ArrayList<PromotionDto> promotionDtos = new ArrayList<>();
        promotionService.getAllPromotions().forEach(promotion -> promotionDtos.add(new PromotionDto(promotion)));
        return promotionDtos;
    }

    @GetMapping("/{id}")
    public PromotionDto getPromotionById(@PathVariable int id) {
        return new PromotionDto(promotionService.getPromotionById(id));
    }

    @GetMapping("/product/{productName}")
    public PromotionDto getPromotionByProductName(@PathVariable String productName) {
        return new PromotionDto(promotionService.getPromotionByProductName(productName));
    }

    @PostMapping
    public PromotionDto addPromotion(@RequestBody PromotionDto promotionDto) {
        Promotion promotion = toPromotion(promotionDto);
        return new PromotionDto(promotionService.addPromotion(promotion));
    }

    @PutMapping()
    public PromotionDto updatePromotion(@RequestBody PromotionDto promotionDto) {
        return new PromotionDto(promotionService.updatePromotion(toPromotion(promotionDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromotion(@PathVariable int id) {
        promotionService.deletePromotion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    private Promotion toPromotion(PromotionDto promotionDto) {
        return new Promotion(promotionDto.getIdNumber(), promotionDto.getName(), promotionDto.getQuantity(), promotionDto.getPrice(), promotionDto.getTotalPrice(), productTypeService.getProductTypeById(promotionDto.getProductTypeId()) );
    }
}