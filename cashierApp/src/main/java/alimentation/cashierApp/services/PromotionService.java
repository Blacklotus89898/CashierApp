package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.PromotionRepository;
import alimentation.cashierApp.exception.CashierAppException;
import alimentation.cashierApp.models.ProductType;
import alimentation.cashierApp.models.Promotion;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository PromotionRepository;
    @Autowired
    private ProductTypeService productTypeService;

    // Add methods for Promotion-related operations here
    public Iterable<Promotion> getAllPromotions() {
        return PromotionRepository.findAll();
    }

    public Promotion getPromotionById(int id) {
        Optional<Promotion> response = PromotionRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    public Promotion getPromotionByProductName(String productName) { // get by type also possible, should use Id
        ProductType productType = productTypeService.getProductTypeByName(productName);
        if (productType == null) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "ProductType missing");
        }
        return PromotionRepository.findByProductType(productType);
    }

    public Promotion addPromotion(Promotion Promotion) {
        return PromotionRepository.save(Promotion);
    }

    public Promotion updatePromotion(Promotion Promotion) {
        return PromotionRepository.save(Promotion);
    }

    public Promotion deletePromotion(int id) {
        Optional<Promotion> target = PromotionRepository.findById(id);
        if (target.get() == null) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Promotion missing");
        }
        PromotionRepository.deleteById(id);
        return target.get();
    }

    public void deleteAllPromotions() {
        PromotionRepository.deleteAll();
    }

}
